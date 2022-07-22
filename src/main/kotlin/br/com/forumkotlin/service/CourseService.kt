package br.com.forumkotlin.service

import br.com.forumkotlin.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(var courses: List<Course> = ArrayList()) {

    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "Programação"
        )

        courses = listOf(course)
    }

    fun findById(id: Long): Course {
        return courses.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }


}
