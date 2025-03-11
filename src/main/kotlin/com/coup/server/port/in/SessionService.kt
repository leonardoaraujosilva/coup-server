package com.coup.server.port.`in`

import com.coup.server.port.`in`.dto.PlayerRequest
import com.coup.server.port.`in`.dto.PlayerResponse

interface SessionService {

    fun disconnectBySessionId(sessionId: String)
    fun login(sessionId: String, payload: PlayerRequest): PlayerResponse

}