package com.arcquila.gameaddict.repository

import com.arcquila.gameaddict.domain.DetailGame
import com.arcquila.gameaddict.domain.Game
import com.arcquila.gameaddict.repository.local.GameDao
import com.arcquila.gameaddict.repository.local.model.GameEntity
import com.arcquila.gameaddict.repository.remote.ApiService

class GamesDataSource(private val remote: ApiService, private val gameDao: GameDao) : GamesRepository{
    override suspend fun getGames(): List<Game> {
        return remote.getGames("715515d6d2ac4b059ed419cdbf8a0c5b").getGames()
    }

    override suspend fun addToFavorite(game: GameEntity) {
        gameDao.insert(game)
    }

    override suspend fun getFavoriteGames(): List<GameEntity> {
        return gameDao.getAllGames()
    }

    override suspend fun getDetailGames(id: String): List<DetailGame> {
        return remote.getDetailGame( id,"715515d6d2ac4b059ed419cdbf8a0c5b").toDetailGame()
    }

    override suspend fun updateFavState(game: DetailGame, newState:Boolean) {
    }

    override suspend fun searchGame(query: String): List<Game> {
        return remote.SearchGame(query, "715515d6d2ac4b059ed419cdbf8a0c5b").getGames()
    }

    override suspend fun deleteFav(game: GameEntity) {
        gameDao.delete(game)
    }
}