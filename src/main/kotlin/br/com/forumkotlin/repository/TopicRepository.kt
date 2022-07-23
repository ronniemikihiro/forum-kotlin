package br.com.forumkotlin.repository

import br.com.forumkotlin.dto.TopicForCategoryDTO
import br.com.forumkotlin.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository: JpaRepository<Topic, Long> {

    fun findByCourseName(nameCourse: String, pageable: Pageable): Page<Topic>

    @Query(" select new br.com.forumkotlin.dto.TopicForCategoryDTO(c.category, count(t)) " +
           " from Topic t " +
           " join t.course c " +
           " group by c.category ")
    fun report(): List<TopicForCategoryDTO>
}