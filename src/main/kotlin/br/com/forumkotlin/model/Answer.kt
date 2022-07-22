package br.com.forumkotlin.model

import java.time.LocalDateTime

data class Answer(
    val id: Long? = null,
    val message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val author: UserForum,
    val topic: Topic,
    val solution: Boolean
)
