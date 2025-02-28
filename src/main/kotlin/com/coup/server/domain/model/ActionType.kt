package com.coup.server.domain.model

import com.coup.server.domain.model.action.*

enum class ActionType(
    val action: Action
) {

    INCOME(Income()),
    FOREIGN_AID(ForeignAid()),
    COUP(Coup()),
    CHALLENGE(Challenge()),
    BLOCK(Block()),
    TAX(Tax()), // duke
    ASSASSINATE(Assassinate()), // assassin
    EXCHANGE(Exchange()), // ambassador
    EXORT(Exort()); // captain

    fun getAction() : Action {
        return action
    }

}