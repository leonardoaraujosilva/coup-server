package com.coup.server.application.usecase.player

import com.coup.server.domain.model.Player
import com.coup.server.port.out.repository.PlayerRepository
import org.springframework.stereotype.Component

@Component
class CreatePlayerUseCase(
    private val repository: PlayerRepository
) {

    fun execute(player: Player) : Player {
        player.validate()
        return repository.save(player)
    }
}