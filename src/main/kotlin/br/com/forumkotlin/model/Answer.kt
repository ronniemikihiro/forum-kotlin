package br.com.forumkotlin.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Answer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val message: String,

    val creationDate: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val author: UserForum,

    @ManyToOne
    val topic: Topic,

    val solution: Boolean
)
