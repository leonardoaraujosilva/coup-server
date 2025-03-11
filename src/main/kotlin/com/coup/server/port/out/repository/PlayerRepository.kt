package com.coup.server.port.out.repository

import com.coup.server.domain.model.Player

interface PlayerRepository {

    fun save(player: Player): Player

}