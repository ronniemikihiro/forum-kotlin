package br.com.forumkotlin.repository

import br.com.forumkotlin.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course, Long> {
    
}