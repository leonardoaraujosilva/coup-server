package com.coup.server.port.out.messaging

import com.coup.server.domain.event.RoomEvent

interface RoomEventNotifier {

    fun send(roomEvent: RoomEvent)

}