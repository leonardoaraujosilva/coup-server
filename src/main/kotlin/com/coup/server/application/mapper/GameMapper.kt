package com.coup.server.application.mapper

import com.coup.server.domain.model.Game
import com.coup.server.port.`in`.dto.game.crud.CreateGameRequest
import com.coup.server.port.`in`.dto.game.GameDetailsResponse

interface GameMapper {

    // TODO should I use mapstruct?
    fun fromCreateGameRequest(input: CreateGameRequest) : Game

    fun toGameDetailsResponse(input: Game) : GameDetailsResponse

}