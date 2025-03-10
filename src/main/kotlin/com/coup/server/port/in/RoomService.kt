package com.coup.server.port.`in`

import com.coup.server.port.`in`.dto.CreateRoomRequest
import com.coup.server.port.`in`.dto.RoomEventResponse
import com.coup.server.port.`in`.dto.RoomResponse
import com.coup.server.port.`in`.dto.RoomSummaryResponse
import java.util.*

interface RoomService {

    fun findAll(): List<RoomSummaryResponse>

    fun create(sessionId: String, payload: CreateRoomRequest): RoomResponse
    fun join(sessionId: String, roomId: UUID): RoomResponse
    fun findById(roomId: UUID): RoomResponse

}