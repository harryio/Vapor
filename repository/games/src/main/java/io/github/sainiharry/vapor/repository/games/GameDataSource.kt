package io.github.sainiharry.vapor.repository.games

internal interface GameDataSource {

    fun getGamesCategoriesJson(): String

}

internal class GameDataSourceImpl : GameDataSource {

    override fun getGamesCategoriesJson(): String = GAME_JSON_DATA
}