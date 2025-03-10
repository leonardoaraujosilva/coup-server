package com.coup.server.port.out.messaging

import com.coup.server.domain.model.Room

interface JoinedRoomMessenger {

    fun send(room: Room)

}