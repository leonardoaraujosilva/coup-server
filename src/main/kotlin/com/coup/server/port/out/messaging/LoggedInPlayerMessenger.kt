package com.coup.server.port.out.messaging

import com.coup.server.domain.event.SessionEvent
import com.coup.server.domain.model.Player

interface LoggedInPlayerMessenger {

    fun send(sessionEvent: SessionEvent)

}