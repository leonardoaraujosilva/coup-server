package com.coup.server.domain.model

import java.util.*
import kotlin.collections.ArrayList

class Player(
    var handCardList : List<Influence> = ArrayList()
) {
    lateinit var id : UUID
    lateinit var nickname: String

    fun isAlive(): Boolean {
        return handCardList.size > 0
    }
}