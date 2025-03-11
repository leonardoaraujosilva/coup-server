package com.coup.server.domain.event

import com.coup.server.domain.model.SessionEventType
import java.time.LocalDateTime
import java.util.*

class SessionEvent (
    val id : UUID = UUID.randomUUID(),
    val timestamp: LocalDateTime = LocalDateTime.now(),
) {

    lateinit var playerId : UUID
    lateinit var type : SessionEventType
    lateinit var data: Any // TODO

}