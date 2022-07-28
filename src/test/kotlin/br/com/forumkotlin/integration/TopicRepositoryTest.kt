package br.com.forumkotlin.integration

import br.com.forumkotlin.dto.TopicForCategoryDTO
import br.com.forumkotlin.model.TopicTest
import br.com.forumkotlin.repository.TopicRepository
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TopicRepositoryTest {

    private val topic = TopicTest.build()

    @Autowired
    private lateinit var topicRepository: TopicRepository

    companion object {
        @Container
        private val postgresqlContainer = PostgreSQLContainer<Nothing>("postgres").apply {
            withDatabaseName("testedb")
            withUsername("ronnie")
            withPassword("123")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgresqlContainer::getJdbcUrl)
            registry.add("spring.datasource.username", postgresqlContainer::getUsername)
            registry.add("spring.datasource.password", postgresqlContainer::getPassword)
        }
    }

    @Test
    fun `must generate a report`() {
        topicRepository.save(topic)
        val report = topicRepository.report()

        assertThat(report).isNotNull
        assertThat(report).first().isExactlyInstanceOf(TopicForCategoryDTO::class.java)
    }

    @Test
    fun `must list topic by course name`() {
        topicRepository.save(topic)
        val topic = topicRepository.findByCourseName(topic.course.name, PageRequest.of(0, 5))

        assertThat(topic).isNotNull
    }
}