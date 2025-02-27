package com.coup.server.adapter.out.messaging

import com.coup.server.domain.event.CreatedGameEvent
import com.coup.server.port.out.messaging.CreatedGamePublisher
import org.springframework.stereotype.Service

@Service
class CreatedGameKafkaPublisher(

) : CreatedGamePublisher {

    override fun publish(event: CreatedGameEvent) {
        TODO("Not yet implemented")
    }
}