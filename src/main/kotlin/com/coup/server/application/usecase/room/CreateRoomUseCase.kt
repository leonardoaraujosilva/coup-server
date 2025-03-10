package com.coup.server.application.usecase.room

import com.coup.server.domain.model.Player
import com.coup.server.domain.model.Room
import com.coup.server.port.out.messaging.CreatedRoomMessenger
import com.coup.server.port.out.messaging.CreatedRoomNotifier
import com.coup.server.port.out.repository.RoomRepository
import org.springframework.stereotype.Component

@Component
class CreateRoomUseCase(
    private val repository: RoomRepository,
    private val messenger: CreatedRoomMessenger,
    private val notifier: CreatedRoomNotifier
) {

    fun execute(room: Room, owner: Player) : Room {
        room.validate()
        room.playerSet.add(owner)

        val stored = repository.save(room)
        messenger.send(stored)
        notifier.send(stored)

        return stored
    }
}