package com.arcquila.gameaddict.repository.remote

import com.arcquila.gameaddict.repository.remote.model.GamesResponse
import com.arcquila.gameaddict.repository.remote.model.detailGames.DetailGameResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("api/games")
    suspend fun getGames(@Query("key") key: String): GamesResponse

    @GET("api/games/{id}")
    suspend fun getDetailGame(@Path("id") id: String, @Query("key") key: String): DetailGameResponse

    @GET("api/games?search={query}")
    suspend fun SearchGame(@Path("query") query: String, @Query("key") key: String): GamesResponse
}