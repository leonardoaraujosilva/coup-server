package com.coup.server.port.`in`.dto

import java.util.UUID

class MatchConnectResponse(
    val id: UUID,
    val type: String?, // deveria ser enum, só pra exemplo
    val playerList: List<String>,
    val useSkins: Boolean
)