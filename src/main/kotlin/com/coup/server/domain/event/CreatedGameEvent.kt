package com.coup.server.domain.event

import java.time.LocalDateTime
import java.util.UUID

class CreatedGameEvent(
    var id : UUID = UUID.randomUUID(),
    var timestamp: LocalDateTime = LocalDateTime.now(),
) {
    lateinit var gameId: UUID
}