package com.coup.server.adapter.out.repository

import com.coup.server.domain.model.Session
import com.coup.server.port.out.repository.SessionRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class SessionRedisRepository : SessionRepository {

    override fun save(session: Session): Session {
        TODO("Not yet implemented")
    }

    override fun findById(sessionId: String): Optional<Session> {
        TODO("Not yet implemented")
    }

    override fun deleteById(sessionId: String) {
        TODO("Not yet implemented")
    }
}