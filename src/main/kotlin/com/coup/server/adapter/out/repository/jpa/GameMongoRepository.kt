package com.coup.server.adapter.out.repository.jpa

import com.coup.server.adapter.out.repository.document.GameDocument
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface GameMongoRepository : CrudRepository<GameDocument, UUID> {
}