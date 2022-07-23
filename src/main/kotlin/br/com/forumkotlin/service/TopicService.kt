package br.com.forumkotlin.service

import br.com.forumkotlin.dto.NewTopicForm
import br.com.forumkotlin.dto.TopicForCategoryDTO
import br.com.forumkotlin.dto.TopicView
import br.com.forumkotlin.dto.UpdateTopicForm
import br.com.forumkotlin.exception.NotFoundException
import br.com.forumkotlin.mapper.TopicFormMapper
import br.com.forumkotlin.mapper.TopicViewMapper
import br.com.forumkotlin.repository.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val topicRepository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topic not found"
) {

    fun listAll(
        nameCourse: String?,
        pageable: Pageable
    ): Page<TopicView> {
        return if (nameCourse == null) {
            topicRepository.findAll(pageable)
        } else {
            topicRepository.findByCourseName(nameCourse, pageable)
        }.map {
            t -> topicViewMapper.map(t)
        }
    }

    fun findById(id: Long): TopicView {
        return topicRepository.findById(id).map {
            t -> topicViewMapper.map(t)
        }.orElseThrow { NotFoundException(notFoundMessage) }
    }

    fun create(newTopicForm: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(newTopicForm)
        topicRepository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun update(updateTopicForm: UpdateTopicForm): TopicView {
        val topic = topicRepository.findById(updateTopicForm.id)
            .orElseThrow { NotFoundException(notFoundMessage) }

        topic.title = updateTopicForm.title
        topic.message = updateTopicForm.message

        return topicViewMapper.map(topic)
    }

    fun delete(id: Long) {
        topicRepository.findById(id)
            .map { t -> topicRepository.delete(t) }
            .orElseThrow { NotFoundException(notFoundMessage) }
    }

    fun report(): List<TopicForCategoryDTO> {
        return topicRepository.report()
    }
}