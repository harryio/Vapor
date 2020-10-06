package io.github.sainiharry.vapor.gamelist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import io.github.sainiharry.vapor.R
import io.github.sainiharry.vapor.common.Game

/**
 * A [RecyclerView.Adapter] that handles displaying game data in a game list
 * @param games a list of [Game] that should be displayed in a list
 */
internal class GamesAdapter(private val games: List<Game>) :
    RecyclerView.Adapter<GamesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GamesViewHolder(parent)

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.bind(games[position])
    }

    override fun getItemCount(): Int = games.size
}

/**
 * A [RecyclerView.ViewHolder] that sets a single game data to a single cell in the games list
 */
internal class GamesViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(viewGroup.context).inflate(R.layout.item_game, viewGroup, false)
) {

    private val posterImageView = itemView.findViewById<ImageView>(R.id.game_poster)
    private val titleTextView = itemView.findViewById<TextView>(R.id.game_title)

    private val cornerRadius = itemView.context.resources.getDimensionPixelSize(R.dimen.size_m)

    fun bind(game: Game) {
        Glide.with(itemView.context)
            .load(game.img)
            .transform(RoundedCorners(cornerRadius))
            .transition(withCrossFade())
            .into(posterImageView)

        titleTextView.text = game.title
    }
}