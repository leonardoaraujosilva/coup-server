package com.coup.server.domain.model

import com.coup.server.domain.exception.InvalidModelException
import java.util.*

class Room(
) {

    fun validate() {
        if (!::name.isInitialized)
            throw InvalidModelException("Invalid room", "The field \"name\" is required")
    }

    var id : UUID? = null
    val playerSet : SortedSet<Player> = TreeSet()
    var useSkins: Boolean = false

    lateinit var name : String
}