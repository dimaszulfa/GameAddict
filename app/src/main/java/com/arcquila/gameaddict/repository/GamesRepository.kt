package com.arcquila.gameaddict.repository

import com.arcquila.gameaddict.domain.Game

interface GamesRepository {
    suspend fun getGames(): List<Game>
}