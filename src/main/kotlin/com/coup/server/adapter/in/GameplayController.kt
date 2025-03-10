package com.coup.server.adapter.`in`

import com.coup.server.port.`in`.GameplayService
import com.coup.server.port.`in`.dto.gameplay.ActionRequest
import com.coup.server.port.`in`.dto.gameplay.ActionResponse
import com.coup.server.port.`in`.dto.gameplay.JoinRequest
import com.coup.server.port.`in`.dto.gameplay.JoinResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class GameplayController(
    private val service: GameplayService
) {

    @PostMapping("/game/{id}/join")
    @ResponseStatus(HttpStatus.OK)
    fun join(@RequestBody payload: JoinRequest) : JoinResponse {
        return service.join(payload)
    }

    @PostMapping("/game/{id}/join")
    @ResponseStatus(HttpStatus.OK)
    fun action(@RequestBody payload: ActionRequest) : ActionResponse {
        return service.action(payload)
    }

}