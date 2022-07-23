package br.com.forumkotlin.service

import br.com.forumkotlin.model.UserForum
import br.com.forumkotlin.repository.UserForumRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserForumService(private val userForumRepository: UserForumRepository) {

    fun findById(id: Long): Optional<UserForum> {
        return userForumRepository.findById(id)
    }


}
