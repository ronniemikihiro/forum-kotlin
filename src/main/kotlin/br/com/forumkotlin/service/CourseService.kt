package br.com.forumkotlin.service

import br.com.forumkotlin.model.Course
import br.com.forumkotlin.repository.CourseRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(
    private val courseRepository: CourseRepository
) {

    fun findById(
        id: Long
    ): Optional<Course> {
        return courseRepository.findById(id)
    }


}
