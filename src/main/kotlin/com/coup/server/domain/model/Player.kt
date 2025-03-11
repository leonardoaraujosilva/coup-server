package com.coup.server.domain.model

import java.util.*
import kotlin.collections.ArrayList

data class Player(
    var id : UUID? = null
) {
    lateinit var name: String
    lateinit var sessionId: String
}