package br.com.forumkotlin.service

import br.com.forumkotlin.exception.NotFoundException
import br.com.forumkotlin.mapper.TopicFormMapper
import br.com.forumkotlin.mapper.TopicViewMapper
import br.com.forumkotlin.model.TopicTest
import br.com.forumkotlin.model.TopicViewTest
import br.com.forumkotlin.repository.TopicRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*

class TopicServiceTest {

    private val topics = PageImpl(listOf(TopicTest.build()))

    private val pageable: Pageable = mockk()

    private val topicRepository: TopicRepository = mockk {
        every { findByCourseName(any(), any()) } returns topics
        every { findAll(pageable) } returns topics
    }

    private val topicViewMapper: TopicViewMapper = mockk {
        every { map(any()) } returns TopicViewTest.build()
    }

    private val topicFormMapper: TopicFormMapper = mockk()

    private val topicService = TopicService(
        topicRepository, topicViewMapper, topicFormMapper
    )

    @Test
    fun `must list topics from the course name`() {
        topicService.listAll("Kotlin Basico", pageable)

        verify(exactly = 1) { topicRepository.findByCourseName(any(), any()) }
        verify(exactly = 1) { topicViewMapper.map(any()) }
        verify(exactly = 0) { topicRepository.findAll(pageable) }
    }

    @Test
    fun `must list all topics when course name is null`() {
        topicService.listAll(null, pageable)

        verify(exactly = 0) { topicRepository.findByCourseName(any(), any()) }
        verify(exactly = 1) { topicViewMapper.map(any()) }
        verify(exactly = 1) { topicRepository.findAll(pageable) }
    }

    @Test
    fun `must return not found exception when topic is not found`() {
        every { topicRepository.findById(any()) } returns Optional.empty()

        val current = assertThrows<NotFoundException> {
            topicService.findById(1)
        }

        assertThat(current.message).isEqualTo("Topic not found")
    }

}