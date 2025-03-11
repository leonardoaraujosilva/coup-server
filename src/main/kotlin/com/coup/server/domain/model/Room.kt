package com.coup.server.domain.model

import com.coup.server.domain.exception.InvalidModelException
import java.util.*

class Room(
) {

    companion object {
        private const val INVALID_TITLE = "Invalid room"
        private const val INVALID_FIELD_NAME = "The field \"name\" is required"
    }

    fun validate() {
        if (!::name.isInitialized)
            throw InvalidModelException(INVALID_TITLE, INVALID_FIELD_NAME)
    }

    var id : UUID? = null
    val playerSet : SortedSet<Player> = TreeSet()
    var useSkins: Boolean = false

    lateinit var name : String
}