package br.com.forumkotlin.repository

import br.com.forumkotlin.model.UserForum
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserForumRepository: JpaRepository<UserForum, Long> {
    fun findByEmail(username: String?): Optional<UserForum>

}