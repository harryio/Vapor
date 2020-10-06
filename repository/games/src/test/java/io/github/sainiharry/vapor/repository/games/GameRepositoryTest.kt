package io.github.sainiharry.vapor.repository.games

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GameRepositoryTest {

    @Mock
    private lateinit var dataSource: GameDataSource

    private lateinit var gamesRepository: GamesRepository

    @Before
    fun setup() {
        gamesRepository = GamesRepositoryImpl(dataSource, TestCoroutineDispatcher())
    }

    @Test
    fun testNoCategories() = runBlockingTest {
        `when`(dataSource.getGamesCategoriesJson()).thenReturn(EMPTY_GAMES_CATEGORIES_DATA)
        assertTrue(gamesRepository.getGamesCategories().isEmpty())
    }

    @Test
    fun testNoGames() = runBlockingTest {
        `when`(dataSource.getGamesCategoriesJson()).thenReturn(GAMES_CATEGORIES_DATA_WITH_NO_GAMES)
        val gamesCategories = gamesRepository.getGamesCategories()
        assertTrue(gamesCategories.all { it.games.isEmpty() })
    }

    @Test
    fun testCategoriesWithGamesAndNoGames() = runBlockingTest {
        `when`(dataSource.getGamesCategoriesJson()).thenReturn(
            GAME_CATEGORIES_DATA_WITH_EMPTY_AND_NON_EMPTY_GAMES
        )
        val gamesCategories = gamesRepository.getGamesCategories()
        assertFalse(gamesCategories.all { it.games.isEmpty() })
        assertFalse(gamesCategories.all { it.games.isNotEmpty() })

        assertTrue(gamesCategories.any { it.games.isEmpty() })
        assertTrue(gamesCategories.any { it.games.isNotEmpty() })
    }

    @Test
    fun testCategoriesWithNonEmptyGames() = runBlockingTest {
        `when`(dataSource.getGamesCategoriesJson()).thenReturn(
            GAME_CATEGORIES_DATA_WITH_NON_EMPTY_DATA
        )
        val gamesCategories = gamesRepository.getGamesCategories()
        assertTrue(gamesCategories.all { it.games.isNotEmpty() })
    }
}

private const val EMPTY_GAMES_CATEGORIES_DATA = "[]"

private const val GAMES_CATEGORIES_DATA_WITH_NO_GAMES = "[\n" +
        "  {\n" +
        "    \"list_title\": \"Mistplay Favorites\",\n" +
        "    \"games\": []\n" +
        "  },\n" +
        "  {\n" +
        "    \"list_title\": \"Fantasy\",\n" +
        "    \"games\": []\n" +
        "  },\n" +
        "  {\n" +
        "    \"list_title\": \"Slots\",\n" +
        "    \"games\": []\n" +
        "  }\n" +
        "]"

private const val GAME_CATEGORIES_DATA_WITH_EMPTY_AND_NON_EMPTY_GAMES = "[\n" +
        "  {\n" +
        "    \"list_title\": \"Mistplay Favorites\",\n" +
        "    \"games\": []\n" +
        "  },\n" +
        "  {\n" +
        "    \"list_title\": \"Fantasy\",\n" +
        "    \"games\": [\n" +
        "      {\n" +
        "        \"title\": \"MonsterLegends\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/monster-legends/Portrait_290x420.png\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Park ofMonster\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/parkofmonster/POM-Portrait.png\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Wizard of Oz Free SlotsCasino\",\n" +
        "        \"img\": \"https://assets.mistplay.com/images/timeplay/games/wizard-of-oz-slots/WoZ_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Game of Thrones Slots Casino - Free SlotMachines\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/got-slots/GoTSlots_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Dragon ManiaLegends\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/dragon-mania/DragonMania_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Lords Mobile: KingdomWars\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/Lords-Mobile/LordsMobile-Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"The Wizard of Oz Magic Match 3 Puzzles &Games\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/wizzard-of-oz/WizardOfOz_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Romancing SaGaRe;univerSe\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/romancing-saga/RomancingSaga_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"RAID: ShadowLegends\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/raid-shadow-legends/RAID_Portrait.jpg\"\n" +
        "      }\n" +
        "    ]\n" +
        "  }\n" +
        "]"

private const val GAME_CATEGORIES_DATA_WITH_NON_EMPTY_DATA = GAME_JSON_DATA