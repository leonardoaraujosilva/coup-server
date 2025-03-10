package com.coup.server.port.`in`.dto

import java.util.UUID

class RoomResponse(
    val id: UUID,
    val name: String,
    val playerList: List<PlayerResponse>
)