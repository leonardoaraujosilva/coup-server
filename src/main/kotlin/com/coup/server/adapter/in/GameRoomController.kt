package com.coup.server.adapter.`in`

import com.coup.server.domain.model.Match
import com.coup.server.port.`in`.dto.MatchConnectRequest
import com.coup.server.port.`in`.dto.MatchConnectResponse
import org.springframework.context.event.EventListener
import org.springframework.http.HttpStatus
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.annotation.SendToUser
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.socket.messaging.SessionDisconnectEvent
import java.util.*

// It is just a test version of this file. You can open the file /index.html twice in your browser to test this controller
// Yes, everything is in the controller because this is my first time working with WebSockets and I'm still testing how it works
@Controller
class GameRoomController(
    private val messagingTemplate: SimpMessagingTemplate
) {

    val users = mutableMapOf<String, String>()
    val matches = mutableMapOf<UUID, Match>()

    // When the user connects to the server, they make a GET (REST) request asking for all available rooms
    @GetMapping("/match")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun getMatchList(): List<MatchConnectResponse> {
        return matches.map { (_, match) -> MatchConnectResponse(
            match.id,
            null, // Using the same DTO just to simplify testing
            match.playerList,
            match.useSkins
        )
        }
    }

    // When a room is created, everyone is notified on /topic/match,
    // and the user who created the room also receives the created room's data on /user/topic/match/create
    @MessageMapping("/match/create")
    @SendToUser("/topic/match/create")
    @SendTo("/topic/match")
    fun createMatch(@Payload payload: MatchConnectRequest,
                    headerAccessor: SimpMessageHeaderAccessor
    ): MatchConnectResponse {
        val matchId = UUID.randomUUID()

        val match = Match(matchId, mutableListOf(payload.nickname), payload.useSkins)
        matches[matchId] = match

        users.put(headerAccessor.sessionId!!, payload.nickname)

        return MatchConnectResponse(
            match.id,
            "ADDED",
            match.playerList,
            match.useSkins
        )
    }

    // When someone joins a room, everyone in that room is notified on /topic/match/{matchId}
    // including the person who joined, as they should already be listening to this topic when connecting
    // (but I will change this to a private event topic if necessary)
    @MessageMapping("/match/{matchId}")
    @SendTo("/topic/match/{matchId}")
    fun test(@DestinationVariable matchId: UUID,
             @Payload payload: MatchConnectRequest,
             headerAccessor: SimpMessageHeaderAccessor): MatchConnectResponse {
        val match = matches[matchId]!!
        users.put(headerAccessor.sessionId!!, payload.nickname)
        match.playerList.add(payload.nickname)

        return MatchConnectResponse(
            match.id,
            null,
            match.playerList,
            match.useSkins
        )
    }

    @EventListener
    fun handleSessionDisconnect(event: SessionDisconnectEvent) {
        // Using nickname as key is weak, but this is just for testing
        val username = users[event.sessionId] ?: return

        val matchOpt = matches.entries.stream()
            .filter { entry -> entry.value.playerList.contains(username) }
            .findFirst()

        if (matchOpt.isEmpty)
            return

        val match = matchOpt.get().value
        match.playerList.remove(username)

        if (match.playerList.isEmpty()) {
            matches.remove(match.id)
            messagingTemplate.convertAndSend("/topic/match", MatchConnectResponse(
                match.id,
                "REMOVED", // Using the same DTO just to simplify testing
                match.playerList,
                match.useSkins
            ))
        } else {
            // Could be a simple event to notify that a user disconnected
            messagingTemplate.convertAndSend("/topic/match/${match.id}", match)
        }
    }
}