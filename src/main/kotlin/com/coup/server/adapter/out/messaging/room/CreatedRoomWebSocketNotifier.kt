package com.coup.server.adapter.out.messaging.room

import com.coup.server.domain.model.Room
import com.coup.server.port.out.messaging.CreatedRoomNotifier
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class CreatedRoomWebSocketNotifier(
    private val messaging: SimpMessagingTemplate
) : CreatedRoomNotifier {

    companion object {
        const val TOPIC_NAME_TEMPLATE = "/topic/room"
    }

    override fun send(room: Room) {
        messaging.convertAndSend(TOPIC_NAME_TEMPLATE, room)
    }
}