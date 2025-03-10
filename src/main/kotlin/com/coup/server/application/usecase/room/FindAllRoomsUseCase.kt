package com.coup.server.application.usecase.room

import com.coup.server.domain.model.Room
import com.coup.server.port.out.repository.RoomRepository
import org.springframework.stereotype.Component

@Component
class FindAllRoomsUseCase(
    private val repository: RoomRepository
) {

    fun execute() : List<Room> {
        return repository.findAll()
    }

}