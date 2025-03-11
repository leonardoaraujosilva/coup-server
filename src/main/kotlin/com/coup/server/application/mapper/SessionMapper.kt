package com.coup.server.application.mapper

import com.coup.server.domain.model.Player
import com.coup.server.domain.model.Session

interface SessionMapper {

    fun fromSessionIdAndPlayer(sessionId: String, player: Player) : Session

}