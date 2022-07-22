package br.com.forumkotlin.exception

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message) {
}