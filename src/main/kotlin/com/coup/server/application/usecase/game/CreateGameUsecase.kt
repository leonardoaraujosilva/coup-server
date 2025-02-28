package com.coup.server.application.usecase.game

import com.coup.server.domain.event.CreatedGameEvent
import com.coup.server.domain.model.Game
import com.coup.server.port.out.messaging.CreatedGamePublisher
import com.coup.server.port.out.repository.GameRepository
import org.springframework.stereotype.Component

@Component
class CreateGameUsecase(
    private val repository: GameRepository,
    private val publisher: CreatedGamePublisher
) {

    fun execute(game: Game): Game {
        game.validate()

        game.initialize()
        val stored = repository.save(game)
        publish(stored)

        return stored
    }

    private fun publish(game: Game) {
        val event = CreatedGameEvent()
        event.gameId = game.id!!
        publisher.publish(event)
    }
}