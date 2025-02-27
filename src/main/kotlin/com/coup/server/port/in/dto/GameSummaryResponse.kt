package com.coup.server.port.`in`.dto

import java.time.LocalDateTime
import java.util.UUID

data class GameSummaryResponse(
    var id : UUID,
    var createdAt: LocalDateTime,
    var updatedAt: LocalDateTime,
    var numberOfPlayers: Int
)
