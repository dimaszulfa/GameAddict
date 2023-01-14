package com.arcquila.gameaddict.repository.remote.model.detailGames

import com.google.gson.annotations.SerializedName

data class PlatformsItem(

	@field:SerializedName("requirements")
	val requirements: Requirements,

	@field:SerializedName("released_at")
	val releasedAt: String,

	@field:SerializedName("platform")
	val platform: Platform
)