package com.coup.server.adapter.`in`

import com.coup.server.port.`in`.GameCrudService
import com.coup.server.port.`in`.dto.game.CreateGameRequest
import com.coup.server.port.`in`.dto.game.crud.CreateGameRequest
import com.coup.server.port.`in`.dto.game.GameDetailsResponse
import com.coup.server.port.`in`.dto.game.GameFilterRequest
import com.coup.server.port.`in`.dto.game.GameSummaryResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class GameCrudController(
    private val service: GameCrudService
) {
    @PostMapping("/game")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody payload: CreateGameRequest) : GameDetailsResponse {
        return service.create(payload)
    }

    @GetMapping("/game/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: UUID) : GameDetailsResponse {
        return service.findById(id)
    }

    @GetMapping("/game")
    @ResponseStatus(HttpStatus.OK)
    fun findAll(filter: GameFilterRequest, pageable: Pageable) : Page<GameSummaryResponse> {
        return service.findAll(filter, pageable)
    }

    @DeleteMapping("/game/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: UUID) {
        service.deleteById(id)
    }
}