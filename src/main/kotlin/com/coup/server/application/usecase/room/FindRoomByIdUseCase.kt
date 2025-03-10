package com.coup.server.application.usecase.room

import com.coup.server.domain.exception.NotFoundException
import com.coup.server.domain.model.Room
import com.coup.server.port.out.repository.RoomRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class FindRoomByIdUseCase(
    private val repository: RoomRepository
) {

    fun execute(roomId: UUID) : Room {
        val room = repository.findById(roomId)

        if (room.isEmpty)
            throw NotFoundException("Room $roomId not found")

        return room.get()
    }
}