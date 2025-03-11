package com.coup.server.application.service

import com.coup.server.application.usecase.player.DisconnectPlayerUseCase
import com.coup.server.application.usecase.player.FindPlayerBySessionIdUseCase
import com.coup.server.port.`in`.SessionService
import org.springframework.stereotype.Service

@Service
class SessionServiceImpl(
    private val findBySessionId: FindPlayerBySessionIdUseCase,
    private val disconnect: DisconnectPlayerUseCase
) : SessionService {

    override fun disconnectBySessionId(sessionId: String) {
        val player = findBySessionId.execute(sessionId)
        disconnect.execute(player)
    }
}