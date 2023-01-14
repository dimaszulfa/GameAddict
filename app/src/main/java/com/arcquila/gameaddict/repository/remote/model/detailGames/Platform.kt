package com.arcquila.gameaddict.repository.remote.model.detailGames

import com.google.gson.annotations.SerializedName

data class Platform(

	@field:SerializedName("image")
	val image: Any,

	@field:SerializedName("games_count")
	val gamesCount: Int,

	@field:SerializedName("year_end")
	val yearEnd: Any,

	@field:SerializedName("year_start")
	val yearStart: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("image_background")
	val imageBackground: String,

	@field:SerializedName("slug")
	val slug: String,

	@field:SerializedName("platform")
	val platform: Int
)