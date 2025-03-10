package com.coup.server.application.usecase.room

import com.coup.server.domain.event.RoomEvent
import com.coup.server.domain.exception.InvalidModelException
import com.coup.server.domain.model.Player
import com.coup.server.domain.model.Room
import com.coup.server.domain.model.RoomEventType
import com.coup.server.port.out.messaging.JoinedRoomMessenger
import com.coup.server.port.out.messaging.RoomEventNotifier
import com.coup.server.port.out.repository.RoomRepository
import org.springframework.stereotype.Component

@Component
class JoinRoomUseCase(
    private val repository: RoomRepository,
    private val messenger: JoinedRoomMessenger,
    private val notifier: RoomEventNotifier
) {

    fun execute(room: Room, player: Player) : Room {
        room.playerSet.add(player)

        if (room.id == null)
            throw InvalidModelException("Invalid room", "You need the room id to join")

        val stored = repository.save(room)

        messenger.send(stored)

        val event = createJoinedRoomEvent(stored, player)
        notifier.send(event)

        return stored
    }

    private fun createJoinedRoomEvent(room: Room, player: Player): RoomEvent {
        val event = RoomEvent()
        event.roomId = room.id!!
        event.type = RoomEventType.USER_CONNECTED
        event.data = player
        return event
    }

}