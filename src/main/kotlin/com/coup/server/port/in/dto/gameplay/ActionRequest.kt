package com.coup.server.port.`in`.dto.gameplay

import com.coup.server.domain.model.ActionType
import java.util.*

class ActionRequest(
    var action: ActionType,
    var playerId: UUID
)