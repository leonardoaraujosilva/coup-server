package com.coup.server.application.usecase.room

import com.coup.server.domain.model.Player
import com.coup.server.domain.model.Room
import org.springframework.stereotype.Component

@Component
class CreateRoomUseCase {

    fun execute(room: Room, owner: Player) : Room {
        TODO()
    }
}