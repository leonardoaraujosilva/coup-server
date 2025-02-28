package com.coup.server.port.`in`

import com.coup.server.port.`in`.dto.gameplay.ActionRequest
import com.coup.server.port.`in`.dto.gameplay.ActionResponse
import com.coup.server.port.`in`.dto.gameplay.JoinRequest
import com.coup.server.port.`in`.dto.gameplay.JoinResponse

interface GameplayService {

    fun join(payload: JoinRequest): JoinResponse

    fun action(payload: ActionRequest): ActionResponse

}