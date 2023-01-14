package com.arcquila.gameaddict.repository.remote.model.detailGames

import com.google.gson.annotations.SerializedName

data class MetacriticPlatformsItem(

	@field:SerializedName("metascore")
	val metascore: Int,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("platform")
	val platform: Platform
)