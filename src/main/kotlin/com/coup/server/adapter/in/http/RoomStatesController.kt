package com.coup.server.adapter.`in`.http

import com.coup.server.port.`in`.RoomService
import com.coup.server.port.`in`.dto.RoomResponse
import com.coup.server.port.`in`.dto.RoomSummaryResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class RoomStatesController(
    private val service : RoomService
) {

    @GetMapping("/api/v1/room")
    fun findAll() : List<RoomSummaryResponse> {
        return service.findAll()
    }

    @GetMapping("/api/v1/room/{roomId}")
    fun findById(@PathVariable roomId: UUID) : RoomResponse {
        return service.findById(roomId)
    }

}