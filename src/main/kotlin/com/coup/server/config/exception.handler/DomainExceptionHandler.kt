package com.coup.server.config.exception.handler

import com.coup.server.domain.exception.DomainException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.net.URI

@ControllerAdvice
class DomainExceptionHandler {

    @ExceptionHandler(DomainException::class)
    fun handleDomainException(exception: DomainException, request: HttpServletRequest): ResponseEntity<ProblemDetail> {

        var problemDetail = ProblemDetail.forStatus(exception.status)
        problemDetail.title = exception.title
        problemDetail.detail = exception.description
        problemDetail.instance = URI.create(request.requestURI);

        return ResponseEntity.status(exception.status)
            .body(problemDetail)
    }
}