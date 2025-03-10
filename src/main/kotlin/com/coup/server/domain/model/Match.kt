package com.coup.server.domain.model

import java.util.*

class Match(
    val id: UUID,
    val playerList: MutableList<String>,
    val useSkins: Boolean
)