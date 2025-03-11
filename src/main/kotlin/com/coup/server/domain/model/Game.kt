package com.coup.server.domain.model

import com.coup.server.domain.exception.InvalidModelException
import java.util.HashMap
import java.util.UUID

class Game(
) {
    var id: UUID? = null
    var numberOfPlayers: Int? = null
    var usingSkins: Boolean = false

    val deckList: MutableList<Card> = ArrayList()
    val revealedCardList: MutableList<Card> = ArrayList()
    val playerStatusMap: MutableMap<UUID, PlayerGameStatus> = HashMap()

    companion object {
        val INVALID_MODEL_TITLE = "Invalid Game"
        val INVALID_MODEL_NUMBER_OF_PLAYERS = "Number of players must be between 4 and 10"

        val DEFAULT_INFLUENCE_SKIN = InfluenceSkin.TYPE_1
        val INFLUENCE_SKINS_AMOUNT = InfluenceSkin.entries.size
        const val EXPECTED_INFLUENCE_TYPES_IN_GAME = 5

        const val TOTAL_CARDS_FROM_FOUR_TO_SIX_PLAYERS = 15
        const val TOTAL_CARDS_FROM_SEVEN_TO_EIGHT_PLAYERS = 20
        const val TOTAL_CARDS_FROM_NINE_TO_TEN_PLAYERS = 25
    }

    fun validate() {
        if (numberOfPlayers == null || numberOfPlayers!! < 4 || numberOfPlayers!! > 10)
            throw InvalidModelException(INVALID_MODEL_TITLE, INVALID_MODEL_NUMBER_OF_PLAYERS)
    }

    fun initialize() {
        if (usingSkins)
            createSkinsCards()

        createMissingCardsWithDefaultSkins()

        shuffleDeck()
    }

    fun shuffleDeck() {
        deckList.shuffle()
    }

    private fun createSkinsCards() {
        for (i in 0 until EXPECTED_INFLUENCE_TYPES_IN_GAME) {
            for (j in 0 until INFLUENCE_SKINS_AMOUNT) {
                val cardCard = Card()
                cardCard.character = InfluenceType.entries[i]
                cardCard.skin = InfluenceSkin.entries[j]
                deckList.add(cardCard)
            }
        }
    }

    private fun calculateMissingCards(): Int {
        if (numberOfPlayers!! <= 6)
            return TOTAL_CARDS_FROM_FOUR_TO_SIX_PLAYERS - deckList.size

        if (numberOfPlayers!! <= 8)
            return TOTAL_CARDS_FROM_SEVEN_TO_EIGHT_PLAYERS - deckList.size

        if (numberOfPlayers!! <= 10)
            return TOTAL_CARDS_FROM_NINE_TO_TEN_PLAYERS - deckList.size

        throw InvalidModelException(INVALID_MODEL_TITLE, INVALID_MODEL_NUMBER_OF_PLAYERS)
    }

    private fun createMissingCardsWithDefaultSkins() {

        val missingCards = calculateMissingCards()

        if (missingCards == 0)
            return

        val missingCardsByType = missingCards / EXPECTED_INFLUENCE_TYPES_IN_GAME

        for (i in 0 until missingCardsByType) {
            for (j in 0 until EXPECTED_INFLUENCE_TYPES_IN_GAME) {
                val cardCard = Card()
                cardCard.character = InfluenceType.entries[j]
                cardCard.skin = DEFAULT_INFLUENCE_SKIN
                deckList.add(cardCard)
            }
        }
    }
}