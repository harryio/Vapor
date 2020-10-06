package io.github.sainiharry.vapor.gamelist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.sainiharry.vapor.R
import io.github.sainiharry.vapor.common.GameCategory

/**
 * A [RecyclerView.Adapter] that handles displaying game categories in a list
 * @param gamesCategories a list of [GameCategory] that should be displayed in a list
 */
internal class GamesCategoriesAdapter(private val gamesCategories: List<GameCategory>) :
    RecyclerView.Adapter<GamesCategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GamesCategoriesViewHolder(parent)

    override fun onBindViewHolder(holder: GamesCategoriesViewHolder, position: Int) {
        holder.bind(gamesCategories[position])
    }

    override fun getItemCount(): Int = gamesCategories.size
}

/**
 * A [RecyclerView.ViewHolder] that sets a single game category data to a single cell in the
 * game category list
 */
internal class GamesCategoriesViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(viewGroup.context).inflate(R.layout.item_game_category, viewGroup, false)
) {

    private val titleTextView = itemView.findViewById<TextView>(R.id.category_title)
    private val gamesRecyclerView = itemView.findViewById<RecyclerView>(R.id.games_recycler_view)

    init {
        gamesRecyclerView.layoutManager =
            LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
    }

    fun bind(gamesCategory: GameCategory) {
        titleTextView.text = gamesCategory.listTitles
        gamesRecyclerView.adapter = GamesAdapter(gamesCategory.games)
    }
}