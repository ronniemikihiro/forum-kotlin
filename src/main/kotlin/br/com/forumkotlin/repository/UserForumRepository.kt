package br.com.forumkotlin.repository

import br.com.forumkotlin.model.UserForum
import org.springframework.data.jpa.repository.JpaRepository

interface UserForumRepository: JpaRepository<UserForum, Long> {

}