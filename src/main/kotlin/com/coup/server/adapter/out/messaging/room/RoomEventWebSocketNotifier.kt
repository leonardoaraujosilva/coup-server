package com.coup.server.adapter.out.messaging.room

import com.coup.server.domain.event.RoomEvent
import com.coup.server.port.out.messaging.RoomEventNotifier
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class RoomEventWebSocketNotifier(
    private val messaging: SimpMessagingTemplate
) : RoomEventNotifier {

    companion object {
        const val TOPIC_NAME_TEMPLATE = "/topic/room/%s"
    }

    override fun send(roomEvent: RoomEvent) {
        val topicName = String.format(TOPIC_NAME_TEMPLATE, roomEvent.roomId)
        messaging.convertAndSend(topicName, roomEvent)
    }
}