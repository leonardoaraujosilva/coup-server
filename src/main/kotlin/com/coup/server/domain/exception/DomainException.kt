package com.coup.server.domain.exception

import org.springframework.http.HttpStatus

abstract class DomainException(
    val status: HttpStatus,
    val title: String,
    val description: String
) : RuntimeException("$title: $description") {
}