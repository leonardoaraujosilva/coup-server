package com.coup.server.domain.model.action

import com.coup.server.domain.model.ActionType
import com.coup.server.domain.model.Game
import java.util.*

class Income : Action {
    override fun execute(game: Game, playerId: UUID) {
        TODO("Not yet implemented")
    }

    override fun isBlockable(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getType(): ActionType {
        TODO("Not yet implemented")
    }
}