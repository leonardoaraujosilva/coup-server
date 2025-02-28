package com.coup.server.domain.model.action

import com.coup.server.domain.model.ActionType
import com.coup.server.domain.model.Game
import com.coup.server.domain.model.Player

interface Action {

    fun execute(game: Game, player: Player)

    fun isBlockable(): Boolean

    fun getType(): ActionType

}