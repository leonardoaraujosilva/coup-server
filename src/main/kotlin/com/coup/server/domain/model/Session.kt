package com.coup.server.domain.model

import com.coup.server.domain.exception.InvalidModelException

class Session {

    lateinit var id: String
    var player: Player? = null

    companion object {
        private const val INVALID_TITLE = "Invalid session"
        private const val INVALID_FIELD_ID = "The field \"id\" is required"
    }

    fun validate() {
        if (!::id.isInitialized)
            throw InvalidModelException(INVALID_TITLE, INVALID_FIELD_ID)
    }
}