package com.coup.server.application.service

import com.coup.server.application.mapper.GameMapper
import com.coup.server.application.usecase.game.CreateGameUsecase
import com.coup.server.port.`in`.GameCrudService
import com.coup.server.port.`in`.dto.CreateGameRequest
import com.coup.server.port.`in`.dto.GameDetailsResponse
import com.coup.server.port.`in`.dto.GameFilterRequest
import com.coup.server.port.`in`.dto.GameSummaryResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class GameCrudServiceImpl(
    //private val mapper: GameMapper,
    private val create: CreateGameUsecase
) : GameCrudService {

    override fun create(payload: CreateGameRequest): GameDetailsResponse {
//        val game = mapper.fromCreateGameRequest(payload)
//        val created = create.execute(game)
//        return mapper.toGameDetailsResponse(created)
        TODO("Not yet implemented")
    }

    override fun findById(id: UUID): GameDetailsResponse {
        TODO("Not yet implemented")
    }

    override fun findAll(filter: GameFilterRequest, pageable: Pageable): Page<GameSummaryResponse> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }
}