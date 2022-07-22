package br.com.forumkotlin.controller

import br.com.forumkotlin.controller.dto.NewTopicForm
import br.com.forumkotlin.controller.dto.TopicView
import br.com.forumkotlin.controller.dto.UpdateTopicForm
import br.com.forumkotlin.service.TopicService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val topicService: TopicService) {

    @GetMapping
    fun listAll(): List<TopicView> {
        return topicService.listAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicView {
        return topicService.findById(id)
    }

    @PostMapping
    fun create(
        @RequestBody @Valid newTopicForm: NewTopicForm,
        uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicView = topicService.create(newTopicForm)
        val uri = uriComponentsBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    fun update(@RequestBody @Valid updateTopicForm: UpdateTopicForm): ResponseEntity<TopicView> {
        val topicView = topicService.update(updateTopicForm)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        topicService.delete(id)
    }

}