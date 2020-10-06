package io.github.sainiharry.vapor

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.sainiharry.vapor.common.Game

class GamesAdapter(private val games: List<Game>) :
    RecyclerView.Adapter<GamesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GamesViewHolder(parent)

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.bind(games[position])
    }

    override fun getItemCount(): Int = games.size
}

class GamesViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(viewGroup.context).inflate(R.layout.item_game, viewGroup, false)
) {

    private val posterImageView = itemView.findViewById<ImageView>(R.id.game_poster)
    private val titleTextView = itemView.findViewById<TextView>(R.id.game_title)

    fun bind(game: Game) {
        Glide.with(itemView.context)
            .load(game.img)
            .into(posterImageView)

        titleTextView.text = game.title
    }
}