package com.coup.server.domain.model

import java.util.*
import kotlin.collections.ArrayList

data class Player(
    var id : UUID? = null
) {
    var handCardList : List<Card> = ArrayList()
    var coins: Int = 2

    lateinit var name: String

    fun isAlive(): Boolean {
        return handCardList.size > 0
    }
}