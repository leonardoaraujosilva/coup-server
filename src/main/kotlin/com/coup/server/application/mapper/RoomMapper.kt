package com.coup.server.application.mapper

import com.coup.server.domain.model.Room
import com.coup.server.port.`in`.dto.CreateRoomRequest
import com.coup.server.port.`in`.dto.RoomResponse
import com.coup.server.port.`in`.dto.RoomSummaryResponse

interface RoomMapper {

    fun fromCreateRoomRequest(payload: CreateRoomRequest): Room

    fun toRoomResponse(created: Room): RoomResponse
    fun toRoomSummaryResponse(created: Room): RoomSummaryResponse

}