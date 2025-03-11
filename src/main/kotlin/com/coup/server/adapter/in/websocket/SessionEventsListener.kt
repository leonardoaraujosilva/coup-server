package com.coup.server.adapter.`in`.websocket

import com.coup.server.port.`in`.SessionService
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Controller
import org.springframework.web.socket.messaging.SessionDisconnectEvent

@Controller
class SessionEventsListener(
    private val service: SessionService
) {

    @EventListener
    fun handleSessionDisconnect(event: SessionDisconnectEvent) {
        service.disconnectBySessionId(event.sessionId)
    }

}