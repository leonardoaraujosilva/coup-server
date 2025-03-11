package com.coup.server.application.usecase.session

import com.coup.server.domain.event.SessionEvent
import com.coup.server.domain.exception.InvalidModelException
import com.coup.server.domain.model.Session
import com.coup.server.domain.model.SessionEventType
import com.coup.server.port.out.messaging.LoggedInPlayerMessenger
import com.coup.server.port.out.repository.SessionRepository
import org.springframework.stereotype.Component

@Component
class CreatePlayerSessionUseCase(
    private val repository: SessionRepository,
    private val messenger: LoggedInPlayerMessenger
) {

    companion object {
        private const val INVALID_TITLE = "Invalid session"
        private const val INVALID_FIELD_PLAYER = "The player is required for a gaming session"
    }

    fun execute(session: Session) : Session {
        session.validate()

        if (session.player == null)
            throw InvalidModelException(INVALID_TITLE, INVALID_FIELD_PLAYER)

        val stored = repository.save(session)

        val event = createLoggedInEvent(stored)
        messenger.send(event)

        return stored
    }

    private fun createLoggedInEvent(session: Session): SessionEvent {
        val event = SessionEvent()
        event.playerId = session.player?.id!!
        event.type = SessionEventType.LOGGED_IN
        event.data = session.player!!
        return event
    }

}