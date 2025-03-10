package com.coup.server.application.usecase.room

import com.coup.server.domain.model.Player
import com.coup.server.domain.model.Room
import org.springframework.stereotype.Component

@Component
class JoinRoomUseCase(

) {

    fun execute(room: Room, player: Player) : Room {
        TODO()
    }

}