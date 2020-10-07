package io.github.sainiharry.vapor.gamelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import io.github.sainiharry.vapor.R
import io.github.sainiharry.vapor.repository.games.GamesRepository
import io.github.sainiharry.vapor.utils.EventObserver
import kotlinx.android.synthetic.main.fragment_games_list.*
import kotlinx.coroutines.Dispatchers

/**
 * A fragment that displays a list of game categories and games
 */
class GamesListFragment : Fragment() {

    private val model by viewModels<GamesViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return GamesViewModel(
                    GamesRepository.getInstance(),
                    Dispatchers.Main.immediate
                ) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model.fetchResults()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_games_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        refresh_layout.setOnRefreshListener {
            model.fetchResults()
        }

        category_recycler_view.setHasFixedSize(true)
        model.gamesCategories.observe(viewLifecycleOwner) {
            category_recycler_view.adapter = GamesCategoriesAdapter(it)
        }

        model.error.observe(viewLifecycleOwner, EventObserver { _ ->
            val snackbar = Snackbar.make(view, R.string.generic_error, Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction(R.string.dismiss) {
                snackbar.dismiss()
            }
            snackbar.setAction(R.string.retry) {
                model.fetchResults()
            }

            snackbar.show()
        })

        model.loading.observe(viewLifecycleOwner) {
            refresh_layout.isRefreshing = it
        }
    }
}