package br.com.forumkotlin.repository

import br.com.forumkotlin.model.Answer
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository: JpaRepository<Answer, Long> {
    
}