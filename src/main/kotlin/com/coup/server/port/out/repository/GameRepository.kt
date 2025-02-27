package com.coup.server.port.out.repository

import com.coup.server.domain.model.Game
import java.util.Optional
import java.util.UUID

interface GameRepository {

    fun save(game: Game): Game

    fun findById(id: UUID): Optional<Game>

}