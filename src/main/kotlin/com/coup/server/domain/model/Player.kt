package com.coup.server.domain.model

import java.util.*
import kotlin.collections.ArrayList

class Player(
) {
    var handCardList : List<Card> = ArrayList()
    var coins: Int = 2

    lateinit var id : UUID
    lateinit var nickname: String

    fun isAlive(): Boolean {
        return handCardList.size > 0
    }
}