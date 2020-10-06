package io.github.sainiharry.vapor

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.github.sainiharry.vapor.common.Game
import io.github.sainiharry.vapor.common.GameCategory
import io.github.sainiharry.vapor.repository.games.GamesRepository
import io.github.sainiharry.vapor.utils.Event
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GamesViewModelTest {

    @Mock
    private lateinit var gamesRepository: GamesRepository

    @Mock
    private lateinit var gamesCategoriesObserver: Observer<List<GameCategory>>

    @Mock
    private lateinit var errorObserver: Observer<Event<Any?>>

    @Mock
    private lateinit var loadingObserver: Observer<Boolean>

    private lateinit var model: GamesViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        model = GamesViewModel(gamesRepository, TestCoroutineDispatcher())
        model.gamesCategories.observeForever(gamesCategoriesObserver)
        model.error.observeForever(errorObserver)
        model.loading.observeForever(loadingObserver)
    }

    @After
    fun tearDown() {
        model.gamesCategories.removeObserver(gamesCategoriesObserver)
        model.error.removeObserver(errorObserver)
        model.loading.removeObserver(loadingObserver)
    }

    @Test
    fun testFetchGameCategoriesSuccess() = runBlockingTest {
        val gamesCategories = getMockGamesCategoriesList()
        `when`(gamesRepository.getGamesCategories()).thenReturn(gamesCategories)

        model.fetchResults()
        verify(loadingObserver).onChanged(true)
        verify(gamesCategoriesObserver).onChanged(gamesCategories)
        verify(loadingObserver).onChanged(false)
        verifyNoMoreInteractions(loadingObserver)
        verifyNoMoreInteractions(gamesCategoriesObserver)
        verifyZeroInteractions(errorObserver)
    }

    @Test
    fun testFetchGameCategoriesFailure() = runBlockingTest {
        `when`(gamesRepository.getGamesCategories()).thenThrow(IllegalStateException())

        model.fetchResults()
        verify(loadingObserver).onChanged(true)
        verify(errorObserver).onChanged(Event(null))
        verify(loadingObserver).onChanged(false)
        verifyNoMoreInteractions(loadingObserver)
        verifyNoMoreInteractions(errorObserver)
        verifyZeroInteractions(gamesCategoriesObserver)
    }

    private fun getMockGamesCategoriesList() = listOf(
        GameCategory(
            "Fantasy",
            listOf(
                Game(
                    "Monster Legends",
                    "https://mistplay-static.s3.amazonaws.com/images/timeplay/games/monster-legends/Portrait_290x420.png"
                )
            )
        )
    )
}