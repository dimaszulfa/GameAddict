package com.arcquila.gameaddict.repository

import com.arcquila.gameaddict.domain.Game
import com.arcquila.gameaddict.repository.local.model.GameEntity

interface GamesRepository {
    suspend fun getGames(): List<Game>
    suspend fun addToFavorite(game: GameEntity)
    suspend fun getFavoriteGames(): List<GameEntity>
}