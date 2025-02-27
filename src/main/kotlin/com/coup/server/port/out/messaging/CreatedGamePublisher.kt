package com.coup.server.port.out.messaging

import com.coup.server.domain.event.CreatedGameEvent

interface CreatedGamePublisher {

    fun publish(event: CreatedGameEvent)

}