package com.coup.server.adapter.out.repository

import com.coup.server.adapter.out.repository.jpa.GameMongoRepository
import com.coup.server.domain.model.Game
import com.coup.server.port.out.repository.GameRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class GameRepositoryImpl(
    private val repository: GameMongoRepository
) : GameRepository {

    override fun save(game: Game): Game {
        TODO("Not yet implemented")
    }

    override fun findById(id: UUID): Optional<Game> {
        TODO("Not yet implemented")
    }
}