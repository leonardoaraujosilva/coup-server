package com.coup.server.domain.model.action

import com.coup.server.domain.model.ActionType
import com.coup.server.domain.model.Game
import com.coup.server.domain.model.Player

class ForeignAid : Action {

    override fun execute(game: Game, player: Player) {
        TODO("Not yet implemented")
    }

    override fun isBlockable(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getType(): ActionType {
        TODO("Not yet implemented")
    }

}
