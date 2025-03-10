package com.coup.server.config.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.support.converter.ByteArrayJsonMessageConverter
import org.springframework.kafka.support.converter.JsonMessageConverter

@Configuration
class KafkaConfig {

    @Bean
    fun messageConverter(objectMapper: ObjectMapper): JsonMessageConverter {
        return ByteArrayJsonMessageConverter(objectMapper)
    }

}