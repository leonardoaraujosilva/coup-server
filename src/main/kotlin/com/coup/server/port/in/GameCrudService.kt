package com.coup.server.port.`in`

import com.coup.server.port.`in`.dto.game.CreateGameRequest
import com.coup.server.port.`in`.dto.game.GameDetailsResponse
import com.coup.server.port.`in`.dto.game.GameFilterRequest
import com.coup.server.port.`in`.dto.game.GameSummaryResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface GameCrudService {

    fun create(payload: CreateGameRequest): GameDetailsResponse

    fun findById(id: UUID): GameDetailsResponse

    fun findAll(filter: GameFilterRequest, pageable: Pageable) : Page<GameSummaryResponse>

    fun deleteById(id: UUID)

}