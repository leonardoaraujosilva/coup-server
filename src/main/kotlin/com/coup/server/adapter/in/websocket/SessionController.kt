package com.coup.server.adapter.`in`.websocket

import com.coup.server.port.`in`.SessionService
import com.coup.server.port.`in`.dto.PlayerRequest
import org.springframework.context.event.EventListener
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.stereotype.Controller
import org.springframework.web.socket.messaging.SessionDisconnectEvent


@Controller
class SessionController(
    private val service: SessionService
) {

    @MessageMapping("/login")
    fun login(payload: PlayerRequest, headerAccessor: SimpMessageHeaderAccessor) {
        service.login(headerAccessor.sessionId, payload)
    }

    @EventListener
    fun handleSessionDisconnect(event: SessionDisconnectEvent) {
        service.disconnectBySessionId(event.sessionId)
    }

}