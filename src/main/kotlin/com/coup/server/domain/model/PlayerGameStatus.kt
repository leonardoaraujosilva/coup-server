package com.coup.server.domain.model

class PlayerGameStatus {

    var handCardList : MutableList<Card> = ArrayList()
    var coins: Int = 2

    fun isAlive(): Boolean {
        return handCardList.size > 0
    }
}