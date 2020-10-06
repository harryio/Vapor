package io.github.sainiharry.vapor.common

data class GameCategory(val listTitles: String, val games: List<Game>)

data class Game(val title: String, val img: String)