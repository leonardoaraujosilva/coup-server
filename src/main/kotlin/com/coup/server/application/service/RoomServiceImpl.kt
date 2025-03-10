package com.coup.server.application.service

import com.coup.server.application.usecase.room.JoinRoomUseCase
import com.coup.server.port.`in`.RoomService
import com.coup.server.port.`in`.dto.CreateRoomRequest
import com.coup.server.port.`in`.dto.RoomEventResponse
import com.coup.server.port.`in`.dto.RoomResponse
import com.coup.server.port.`in`.dto.RoomSummaryResponse
import org.springframework.stereotype.Service
import java.util.*

@Service
class RoomServiceImpl(
    private val connect: JoinRoomUseCase
) : RoomService {

    override fun create(sessionId: String, payload: CreateRoomRequest): RoomSummaryResponse {
        TODO("Not yet implemented")
    }

    override fun join(sessionId: String, roomId: UUID): RoomEventResponse {
        TODO("Not yet implemented")
    }

    override fun findById(roomId: UUID): RoomResponse {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<RoomSummaryResponse> {
        TODO("Not yet implemented")
    }
}