package com.arcquila.gameaddict.repository.remote

import com.arcquila.gameaddict.repository.remote.model.GamesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/games")
    suspend fun getGames(@Query("key") key: String): GamesResponse
}