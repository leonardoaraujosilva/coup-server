package com.coup.server.application.mapper

import com.coup.server.domain.model.Player
import com.coup.server.port.`in`.dto.PlayerRequest
import com.coup.server.port.`in`.dto.PlayerResponse

interface PlayerMapper {

    fun fromPlayerRequest(input: PlayerRequest) : Player

    fun toPlayerResponse(input: Player) : PlayerResponse

}