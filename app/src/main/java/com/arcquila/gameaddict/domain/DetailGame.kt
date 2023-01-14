package com.arcquila.gameaddict.domain

import com.arcquila.gameaddict.repository.local.model.GameEntity

data class DetailGame(
    val id : String,
    val name: String,
    val publisher: String,
    val backgroundImage: String,
    val description: String,
    val releaseDate: String,
    val rating: String,
    val playtime: String,
    var isFavorite: Boolean
)   {
    fun toGameEntity(): GameEntity {
        return GameEntity(id,name,backgroundImage,releaseDate,rating,isFavorite)
    }

}