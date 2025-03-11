package com.coup.server.port.out.repository

import com.coup.server.domain.model.Session
import java.util.*

interface SessionRepository {

    fun save(session: Session): Session

    fun findById(sessionId: String): Optional<Session>

    fun deleteById(sessionId: String)

}