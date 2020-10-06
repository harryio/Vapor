package io.github.sainiharry.vapor.repository.games

internal interface GameDataSource {

    fun getGamesCategories(): String
}

internal class GameDataSourceImpl : GameDataSource {

    override fun getGamesCategories(): String = GAME_JSON_DATA
}