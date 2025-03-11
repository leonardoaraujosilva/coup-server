package com.coup.server.domain.model

import com.coup.server.domain.exception.InvalidModelException
import java.util.*

data class Player(
    var id : UUID? = null
) {
    lateinit var name: String
    lateinit var sessionId: String

    companion object {
        private const val INVALID_TITLE = "Invalid player"
        private const val INVALID_FIELD_NAME = "The field \"name\" is required"
        private const val INVALID_FIELD_SESSION_ID = "The field \"sessionId\" is required"
    }

    fun validate() {
        if (!::name.isInitialized)
            throw InvalidModelException(INVALID_TITLE, INVALID_FIELD_NAME)

        if (!::sessionId.isInitialized)
            throw InvalidModelException(INVALID_TITLE, INVALID_FIELD_SESSION_ID)
    }
}