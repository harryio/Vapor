package io.github.sainiharry.vapor.repository.games

import org.junit.Assert.assertEquals
import org.junit.Test

class GameDataSourceTest {

    @Test
    fun testGetGamesCategoriesJson() {
        val gameDataSource = GameDataSourceImpl()
        assertEquals(GAME_JSON_DATA, gameDataSource.getGamesCategoriesJson())
    }
}