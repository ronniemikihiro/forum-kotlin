package br.com.forumkotlin.model

import br.com.forumkotlin.dto.TopicView
import java.time.LocalDate
import java.time.LocalDateTime

object TopicViewTest {
    fun build() = TopicView(
        id = 1,
        title = "Kotlin Basico",
        message = "Aprendendo Kotlin Basico",
        status = StatusTopic.NOT_ANSWERED,
        creationDate = LocalDateTime.now(),
        changeDate = LocalDate.now()
    )
}