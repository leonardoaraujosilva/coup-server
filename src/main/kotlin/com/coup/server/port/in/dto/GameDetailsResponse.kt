package com.coup.server.port.`in`.dto

import java.time.LocalDateTime
import java.util.*

data class GameDetailsResponse(
    var id : UUID,
    var createdAt: LocalDateTime,
    var updatedAt: LocalDateTime,
    var numberOfPlayers: Int,
    var moveHistoryList: List<String> // TODO
)
