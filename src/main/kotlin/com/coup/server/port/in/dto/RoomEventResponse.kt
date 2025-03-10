package com.coup.server.port.`in`.dto

import com.coup.server.domain.model.RoomEventType
import java.util.UUID

class RoomEventResponse(
    val type: RoomEventType,
    val roomId: UUID,
    val data: Any // TODO
)