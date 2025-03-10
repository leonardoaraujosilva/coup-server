package com.coup.server.port.out.repository

import com.coup.server.domain.model.Room
import java.util.*

interface RoomRepository {

    fun save(room: Room) : Room

    fun findById(id: UUID) : Optional<Room>

    fun findAll() : List<Room>

    fun deleteById(id: UUID)

}