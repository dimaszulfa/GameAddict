package com.arcquila.gameaddict.repository

import com.arcquila.gameaddict.domain.Game
import com.arcquila.gameaddict.repository.remote.ApiService

class GamesDataSource(private val remote: ApiService) : GamesRepository{
    override suspend fun getGames(): List<Game> {
        return remote.getGames("715515d6d2ac4b059ed419cdbf8a0c5b").getGames()
    }
}