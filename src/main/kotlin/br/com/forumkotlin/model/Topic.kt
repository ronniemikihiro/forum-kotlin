package br.com.forumkotlin.model

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topic(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var title: String,

    var message: String,

    val creationDate: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val course: Course,

    @ManyToOne
    val author: UserForum,

    @Enumerated(EnumType.STRING)
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,

    @OneToMany(mappedBy = "topic")
    val answers: List<Answer> = ArrayList(),

    var changeDate: LocalDate? = null
)