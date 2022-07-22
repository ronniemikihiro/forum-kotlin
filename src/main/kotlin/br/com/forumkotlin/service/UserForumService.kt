package br.com.forumkotlin.service

import br.com.forumkotlin.model.UserForum
import org.springframework.stereotype.Service

@Service
class UserForumService(var userForums: List<UserForum> = ArrayList()) {

    init {
        val userForum = UserForum(
            id = 1,
            name = "UserForum 1",
            email = "userForum1@email.com"
        )

        userForums = listOf(userForum)
    }

    fun findById(id: Long): UserForum {
        return userForums.stream().filter { u ->
            u.id == id
        }.findFirst().get()
    }


}
