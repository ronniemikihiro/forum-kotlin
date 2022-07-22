package br.com.forumkotlin.controller.dto

import br.com.forumkotlin.model.StatusTopic
import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val message: String,
    val status: StatusTopic,
    val creationDate: LocalDateTime
)
