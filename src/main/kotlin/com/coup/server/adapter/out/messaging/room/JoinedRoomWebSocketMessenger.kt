package com.coup.server.adapter.out.messaging.room

import com.coup.server.domain.model.Room
import com.coup.server.port.out.messaging.JoinedRoomMessenger
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class JoinedRoomWebSocketMessenger(
    private val messaging: SimpMessagingTemplate
) : JoinedRoomMessenger {

    companion object {
        const val TOPIC_NAME_TEMPLATE = "/user/topic/room/%s"
    }

    override fun send(room: Room) {
        val topicName = String.format(RoomEventWebSocketNotifier.TOPIC_NAME_TEMPLATE, room.id)
        messaging.convertAndSend(topicName, room)
    }
}