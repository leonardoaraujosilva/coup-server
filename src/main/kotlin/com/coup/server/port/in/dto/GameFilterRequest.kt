package com.coup.server.port.`in`.dto

import java.time.LocalDateTime
import java.util.UUID

data class GameFilterRequest(
    var startTimestamp: LocalDateTime,
    var endTimestamp: LocalDateTime,
    var finished: Boolean
)
