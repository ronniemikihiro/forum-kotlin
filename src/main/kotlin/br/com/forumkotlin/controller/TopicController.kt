package br.com.forumkotlin.controller

import br.com.forumkotlin.dto.NewTopicForm
import br.com.forumkotlin.dto.TopicForCategoryDTO
import br.com.forumkotlin.dto.TopicView
import br.com.forumkotlin.dto.UpdateTopicForm
import br.com.forumkotlin.service.TopicService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val topicService: TopicService) {

    @GetMapping
    @Cacheable("topics")
    fun listAll(
        @RequestParam(required = false) nameCourse: String?,
        @PageableDefault(size = 5, sort = ["creationDate"], direction = Sort.Direction.DESC) pageable: Pageable
    ): Page<TopicView> {
        return topicService.listAll(nameCourse, pageable)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicView {
        return topicService.findById(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun create(
        @RequestBody @Valid newTopicForm: NewTopicForm,
        uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicView = topicService.create(newTopicForm)
        val uri = uriComponentsBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun update(@RequestBody @Valid updateTopicForm: UpdateTopicForm): ResponseEntity<TopicView> {
        val topicView = topicService.update(updateTopicForm)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun delete(@PathVariable id: Long) {
        topicService.delete(id)
    }

    @GetMapping("/report")
    fun report(): List<TopicForCategoryDTO> {
        return topicService.report()
    }

}