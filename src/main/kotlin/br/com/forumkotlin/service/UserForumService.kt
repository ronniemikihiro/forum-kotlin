package br.com.forumkotlin.service

import br.com.forumkotlin.exception.NotFoundException
import br.com.forumkotlin.model.UserForum
import br.com.forumkotlin.repository.UserForumRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserForumService(
    private val userForumRepository: UserForumRepository,
    private val notFoundMessage: String = "User not found"
): UserDetailsService {

    fun findById(
        id: Long
    ): Optional<UserForum> {
        return userForumRepository.findById(id)
    }

    override fun loadUserByUsername(
        username: String?
    ): UserDetails {
        return userForumRepository.findByEmail(username)
                .orElseThrow{ NotFoundException(notFoundMessage) }
    }

}
