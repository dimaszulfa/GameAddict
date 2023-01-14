package com.arcquila.gameaddict.repository

import com.arcquila.gameaddict.domain.DetailGame
import com.arcquila.gameaddict.domain.Game
import com.arcquila.gameaddict.repository.local.model.GameEntity

interface GamesRepository {
    suspend fun getGames(): List<Game>
    suspend fun addToFavorite(game: GameEntity)
    suspend fun getFavoriteGames(): List<GameEntity>
    suspend fun getDetailGames(id: String): List<DetailGame>
    suspend fun updateFavState(game: DetailGame, newState: Boolean)
    suspend fun searchGame(query: String): List<Game>
    suspend fun deleteFav(game: GameEntity)
}