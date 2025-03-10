package com.coup.server.adapter.`in`.websocket

import com.coup.server.port.`in`.RoomService
import com.coup.server.port.`in`.dto.CreateRoomRequest
import com.coup.server.port.`in`.dto.RoomEventResponse
import com.coup.server.port.`in`.dto.RoomSummaryResponse
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.messaging.simp.annotation.SendToUser
import org.springframework.stereotype.Controller
import java.util.UUID

@Controller
class RoomWSController(
    private val service: RoomService
) {

    // TODO should I use @SendToUser and @SendTo to call WS topics or should I use messagingTemplate to call it?

    @MessageMapping("/room/create")
    @SendToUser("/topic/room/create")
    @SendTo("/topic/room")
    fun createRoom(@Payload payload: CreateRoomRequest,
                    headerAccessor: SimpMessageHeaderAccessor
    ): RoomSummaryResponse {
        return service.create(headerAccessor.sessionId!!, payload)
    }

    @MessageMapping("/room/{roomId}/connect")
    @SendToUser("/topic/room/{roomId}")
    @SendTo("/topic/room/{roomId}")
    fun connectToRoom(@DestinationVariable roomId : UUID,
                      headerAccessor: SimpMessageHeaderAccessor) : RoomEventResponse {
        return service.join(headerAccessor.sessionId!!, roomId)
    }
}