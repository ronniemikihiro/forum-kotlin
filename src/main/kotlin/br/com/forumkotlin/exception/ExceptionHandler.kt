package br.com.forumkotlin.exception

import br.com.forumkotlin.controller.dto.ErrorView
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    fun instanceErrorView(
        message: String?,
        httpServletRequest: HttpServletRequest,
        httpStatus: HttpStatus
    ): ErrorView {
        return ErrorView(
            status = httpStatus.value(),
            error = httpStatus.name,
            message = message,
            path = httpServletRequest.servletPath
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(
        exception: Exception,
        httpServletRequest: HttpServletRequest
    ): ErrorView {
        return instanceErrorView(exception.message, httpServletRequest, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidation(
        exception: MethodArgumentNotValidException,
        httpServletRequest: HttpServletRequest
    ): ErrorView {
        val errorMessage = HashMap<String, String?>()
        exception.bindingResult.fieldErrors.forEach{
            e -> errorMessage[e.field] = e.defaultMessage
        }
        return instanceErrorView(errorMessage.toString(), httpServletRequest, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(
        notFoundException: NotFoundException,
        httpServletRequest: HttpServletRequest
    ): ErrorView {
        return instanceErrorView(notFoundException.message, httpServletRequest, HttpStatus.NOT_FOUND)
    }

}