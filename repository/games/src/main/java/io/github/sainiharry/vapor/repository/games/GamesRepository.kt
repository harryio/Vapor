package io.github.sainiharry.vapor.repository.games

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import io.github.sainiharry.vapor.common.GameCategory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.dsl.module

/**
 * Koin module for providing single instance of GamesRepository
 */
val gamesRepositoryModule = module {
    single<GamesRepository> {
        GamesRepositoryImpl(GameDataSourceImpl(), Dispatchers.IO)
    }
}

/**
 * Repository for accessing games categories and the games for those categories
 */
interface GamesRepository {

    /**
     * Get list of games categories
     */
    suspend fun getGamesCategories(): List<GameCategory>
}

/**
 * Internal implementation of [GamesRepository]
 * @param gameDataSource A data source for fetching json data for games
 * @param coroutineDispatcher A [CoroutineDispatcher] on which the game data will be fetched
 */
internal class GamesRepositoryImpl(
    private val gameDataSource: GameDataSource,
    private val coroutineDispatcher: CoroutineDispatcher
) :
    GamesRepository {

    private val moshi by lazy {
        Moshi.Builder().build()
    }

    override suspend fun getGamesCategories(): List<GameCategory> =
        withContext(coroutineDispatcher) {
            val gameCategoriesType =
                Types.newParameterizedType(List::class.java, GameCategoryModel::class.java)
            val gameCategoryAdapter: JsonAdapter<List<GameCategoryModel>> =
                moshi.adapter(gameCategoriesType)

            gameCategoryAdapter.fromJson(gameDataSource.getGamesCategories())
                ?.map { it.toGameCategory() } ?: emptyList()
        }
}