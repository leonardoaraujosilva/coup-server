package com.coup.server.adapter.out.messaging.session

import com.coup.server.domain.event.SessionEvent
import com.coup.server.port.out.messaging.LoggedInPlayerMessenger
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class LoggedInPlayerWebSocketMessenger(
    private val messaging: SimpMessagingTemplate
) : LoggedInPlayerMessenger {

    companion object {
        const val TOPIC_NAME_TEMPLATE = "/user/topic/session"
    }

    override fun send(sessionEvent: SessionEvent) {
        messaging.convertAndSend(TOPIC_NAME_TEMPLATE, sessionEvent)
    }
}