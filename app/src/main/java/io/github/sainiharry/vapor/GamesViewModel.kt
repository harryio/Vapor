package io.github.sainiharry.vapor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.sainiharry.vapor.common.GameCategory
import io.github.sainiharry.vapor.repository.games.GamesRepository
import io.github.sainiharry.vapor.utils.Event
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class GamesViewModel(
    private val repository: GamesRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _gamesCategories = MutableLiveData<List<GameCategory>>()
    val gamesCategories: LiveData<List<GameCategory>>
        get() = _gamesCategories

    private val _errorLiveData = MutableLiveData<Event<Any?>>()
    val error: LiveData<Event<Any?>>
        get() = _errorLiveData

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    internal fun fetchResults() = viewModelScope.launch(coroutineDispatcher) {
        _loading.value = true
        try {
            _gamesCategories.value = repository.getGamesCategories()
        } catch (e: Exception) {
            e.printStackTrace()
            _errorLiveData.value = Event(null)
        }
        _loading.value = false
    }
}