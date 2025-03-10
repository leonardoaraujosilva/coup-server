package com.coup.server.application.usecase.player

import com.coup.server.domain.model.Player
import org.springframework.stereotype.Component

@Component
class FindPlayerBySessionIdUseCase {

    fun execute(sessionId: String) : Player {
        TODO()
    }

}