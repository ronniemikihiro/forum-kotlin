package br.com.forumkotlin.service

import br.com.forumkotlin.controller.dto.NewTopicForm
import br.com.forumkotlin.controller.dto.TopicView
import br.com.forumkotlin.controller.dto.UpdateTopicForm
import br.com.forumkotlin.exception.NotFoundException
import br.com.forumkotlin.mapper.TopicFormMapper
import br.com.forumkotlin.mapper.TopicViewMapper
import br.com.forumkotlin.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topic not found"
) {

    fun listAll(): List<TopicView> {
        return topics.stream().map {
                t -> topicViewMapper.map(t)
        }.toList()
    }

    fun findById(id: Long): TopicView {
        return topics.stream().filter { t ->
            t.id == id
        }.findFirst().map {
            t -> topicViewMapper.map(t)
        }.orElseThrow { NotFoundException(notFoundMessage) }
    }

    fun create(newTopicForm: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(newTopicForm)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(updateTopicForm: UpdateTopicForm): TopicView {
        val topic = topics.stream().filter { t ->
            t.id == updateTopicForm.id
        }.findFirst()
            .orElseThrow { NotFoundException(notFoundMessage) }

        val updateTopic = Topic(
            id = updateTopicForm.id,
            title = updateTopicForm.title,
            message = updateTopicForm.message,
            creationDate = topic.creationDate,
            author = topic.author,
            course = topic.course,
            answers = topic.answers,
            status = topic.status
        )

        topics = topics
            .minus(topic)
            .plus(updateTopic)

        return topicViewMapper.map(updateTopic)
    }

    fun delete(id: Long) {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst()
            .orElseThrow { NotFoundException(notFoundMessage) }

        topics = topics
            .minus(topic)
    }
}