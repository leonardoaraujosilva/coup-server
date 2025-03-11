package com.coup.server.application.usecase.player

import com.coup.server.domain.model.Player
import org.springframework.stereotype.Component

@Component
class DisconnectPlayerUseCase {

    fun execute(player: Player) {
        TODO("Remove from games, rooms (delete room if no more players), session ID map and notify players")

//        // Using nickname as key is weak, but this is just for testing
//        val username = users[event.sessionId] ?: return
//
//        val matchOpt = matches.entries.stream()
//            .filter { entry -> entry.value.playerList.contains(username) }
//            .findFirst()
//
//        if (matchOpt.isEmpty)
//            return
//
//        val match = matchOpt.get().value
//        match.playerList.remove(username)
//
//        if (match.playerList.isEmpty()) {
//            matches.remove(match.id)
//            messagingTemplate.convertAndSend("/topic/match", MatchConnectResponse(
//                match.id,
//                "REMOVED", // Using the same DTO just to simplify testing
//                match.playerList,
//                match.useSkins
//            ))
//        } else {
//            // Could be a simple event to notify that a user disconnected
//            messagingTemplate.convertAndSend("/topic/match/${match.id}", match)
//        }

    }
}