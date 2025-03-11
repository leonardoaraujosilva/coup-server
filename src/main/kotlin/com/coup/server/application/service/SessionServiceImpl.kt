package com.coup.server.application.service

import com.coup.server.application.mapper.PlayerMapper
import com.coup.server.application.mapper.SessionMapper
import com.coup.server.application.usecase.player.CreatePlayerUseCase
import com.coup.server.application.usecase.player.DisconnectPlayerUseCase
import com.coup.server.application.usecase.player.FindPlayerBySessionIdUseCase
import com.coup.server.application.usecase.session.CreatePlayerSessionUseCase
import com.coup.server.port.`in`.SessionService
import com.coup.server.port.`in`.dto.PlayerRequest
import com.coup.server.port.`in`.dto.PlayerResponse
import org.springframework.stereotype.Service

@Service
class SessionServiceImpl(
    private val playerMapper: PlayerMapper,
    private val sessionMapper: SessionMapper,
    private val createPlayer: CreatePlayerUseCase,
    private val findBySessionId: FindPlayerBySessionIdUseCase,
    private val disconnect: DisconnectPlayerUseCase,
    private val createSession: CreatePlayerSessionUseCase
) : SessionService {

    override fun disconnectBySessionId(sessionId: String) {
        val player = findBySessionId.execute(sessionId)
        disconnect.execute(player)
    }

    override fun login(sessionId: String, payload: PlayerRequest) : PlayerResponse {
        val player = playerMapper.fromPlayerRequest(payload)
        val storedPlayer = createPlayer.execute(player)

        val session = sessionMapper.fromSessionIdAndPlayer(sessionId, storedPlayer)
        val storedSession = createSession.execute(session)

        return playerMapper.toPlayerResponse(storedPlayer)
    }
}