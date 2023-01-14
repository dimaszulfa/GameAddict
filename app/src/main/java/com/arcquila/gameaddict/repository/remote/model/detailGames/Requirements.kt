package com.arcquila.gameaddict.repository.remote.model.detailGames

import com.google.gson.annotations.SerializedName

data class Requirements(

	@field:SerializedName("minimum")
	val minimum: String,

	@field:SerializedName("recommended")
	val recommended: String
)