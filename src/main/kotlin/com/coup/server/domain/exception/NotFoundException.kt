package com.coup.server.domain.exception

import org.springframework.http.HttpStatus

class NotFoundException(details: String) :
    DomainException(HttpStatus.NOT_FOUND, "Resource not found", details) {
}