package io.github.sainiharry.vapor.repository.games

/**
 * Data source for fetching game related data
 */
internal interface GameDataSource {

    /**
     * Fetch game categories
     */
    fun getGamesCategories(): String
}

/**
 * An internal and default implementation of [GameDataSource]
 */
internal class GamesDataSourceImpl : GameDataSource {

    override fun getGamesCategories(): String = GAME_JSON_DATA
}