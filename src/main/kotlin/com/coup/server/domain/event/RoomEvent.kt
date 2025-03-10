package com.coup.server.domain.event

import com.coup.server.domain.model.RoomEventType
import java.time.LocalDateTime
import java.util.UUID

class RoomEvent(
    val id : UUID = UUID.randomUUID(),
    val timestamp: LocalDateTime = LocalDateTime.now(),
) {

    lateinit var roomId : UUID
    lateinit var type : RoomEventType
    lateinit var data: Any // TODO

}