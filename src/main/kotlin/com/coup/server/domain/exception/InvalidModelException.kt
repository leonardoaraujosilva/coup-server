package com.coup.server.domain.exception

import org.springframework.http.HttpStatus

class InvalidModelException(title: String, details: String) :
    DomainException(HttpStatus.UNPROCESSABLE_ENTITY, title, details) {
}