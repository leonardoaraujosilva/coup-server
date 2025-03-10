package com.coup.server.adapter.`in`.websocket

import com.coup.server.port.`in`.RoomService
import com.coup.server.port.`in`.dto.CreateRoomRequest
import com.coup.server.port.`in`.dto.RoomResponse
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class RoomWSController(
    private val service: RoomService
) {

    // TODO should I use @SendToUser and @SendTo to call WS topics or should I use messagingTemplate to call it?

    @MessageMapping("/room/create")
    @SendTo("/topic/room")
    fun createRoom(@Payload payload: CreateRoomRequest,
                    headerAccessor: SimpMessageHeaderAccessor
    ): RoomResponse {
        return service.create(headerAccessor.sessionId!!, payload)
    }

    @MessageMapping("/room/{roomId}/connect")
    fun connectToRoom(@DestinationVariable roomId : UUID,
                      headerAccessor: SimpMessageHeaderAccessor) : RoomResponse {
        return service.join(headerAccessor.sessionId!!, roomId)
    }
}