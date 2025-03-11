package com.coup.server.adapter.out.repository

import com.coup.server.domain.model.Player
import com.coup.server.port.out.repository.PlayerRepository
import org.springframework.stereotype.Repository

@Repository
class PlayerRedisRepository : PlayerRepository {

    override fun save(player: Player): Player {
        TODO("Not yet implemented")
    }

}