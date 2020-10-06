package io.github.sainiharry.vapor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.sainiharry.vapor.common.GameCategory
import io.github.sainiharry.vapor.repository.games.GamesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class GamesViewModel(
    private val repository: GamesRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _gamesCategories = MutableLiveData<List<GameCategory>>()
    val gamesCategories: LiveData<List<GameCategory>>
        get() = _gamesCategories

    init {
        viewModelScope.launch(coroutineDispatcher) {
            _gamesCategories.value = repository.getGamesCategories()
        }
    }
}