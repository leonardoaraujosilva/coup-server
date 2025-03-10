package com.coup.server.adapter.out.messaging.room

import com.coup.server.domain.model.Room
import com.coup.server.port.out.messaging.CreatedRoomMessenger
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class CreatedRoomWebSocketMessenger(
    private val messaging: SimpMessagingTemplate
) : CreatedRoomMessenger {

    companion object {
        const val TOPIC_NAME_TEMPLATE = "/user/topic/room/create"
    }

    override fun send(room: Room) {
        messaging.convertAndSend(TOPIC_NAME_TEMPLATE, room)
    }
}