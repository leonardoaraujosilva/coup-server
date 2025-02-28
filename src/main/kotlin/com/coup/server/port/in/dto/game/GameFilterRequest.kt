package com.coup.server.port.`in`.dto.game

import java.time.LocalDateTime

data class GameFilterRequest(
    var startTimestamp: LocalDateTime,
    var endTimestamp: LocalDateTime,
    var finished: Boolean
)
