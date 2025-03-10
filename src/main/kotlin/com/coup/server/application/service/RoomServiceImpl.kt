package com.coup.server.application.service

import com.coup.server.application.mapper.RoomMapper
import com.coup.server.application.usecase.player.FindPlayerBySessionIdUseCase
import com.coup.server.application.usecase.room.CreateRoomUseCase
import com.coup.server.application.usecase.room.FindAllRoomsUseCase
import com.coup.server.application.usecase.room.FindRoomByIdUseCase
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
    private val mapper: RoomMapper,
    private val findPlayer: FindPlayerBySessionIdUseCase,
    private val create: CreateRoomUseCase,
    private val join: JoinRoomUseCase,
    private val findById: FindRoomByIdUseCase,
    private val findAll: FindAllRoomsUseCase,
) : RoomService {

    // TODO bind sessionId to user

    override fun create(sessionId: String, payload: CreateRoomRequest): RoomResponse {
        val player = findPlayer.execute(sessionId)
        val room = mapper.fromCreateRoomRequest(payload)
        val created = create.execute(room, player)
        return mapper.toRoomResponse(created)
    }

    override fun join(sessionId: String, roomId: UUID): RoomResponse {
        val player = findPlayer.execute(sessionId)
        val room = findById.execute(roomId)
        val joined = join.execute(room, player)
        return mapper.toRoomResponse(joined)
    }

    override fun findById(roomId: UUID): RoomResponse {
        val room = findById.execute(roomId)
        return mapper.toRoomResponse(room)
    }

    override fun findAll(): List<RoomSummaryResponse> {
        val roomList = findAll.execute()
        return roomList.map { room -> mapper.toRoomSummaryResponse(room) }
    }
}