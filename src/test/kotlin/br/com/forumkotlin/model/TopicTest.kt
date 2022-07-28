package br.com.forumkotlin.model

object TopicTest {
    fun build() = Topic(
        id = 1,
        title = "Kotlin Basico",
        message = "Aprendendo Kotlin Basico",
        course = CourseTest.build(),
        author = UserForumTest.build()
    )
}