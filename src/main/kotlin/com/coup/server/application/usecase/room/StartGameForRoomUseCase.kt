package com.coup.server.application.usecase.room

import com.coup.server.domain.model.Game
import com.coup.server.domain.model.Room
import org.springframework.stereotype.Component

@Component
class StartGameForRoomUseCase() {

    fun execute(room: Room) : Game {
        TODO("Create game using room data. Change status of the room and bind this game to each player")
    }
}