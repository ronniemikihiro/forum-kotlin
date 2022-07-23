package br.com.forumkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class ForumKotlinApplication

fun main(args: Array<String>) {
	runApplication<ForumKotlinApplication>(*args)
}
