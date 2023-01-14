package com.arcquila.gameaddict.repository.remote.model.detailGames

import com.google.gson.annotations.SerializedName

data class ParentPlatformsItem(

	@field:SerializedName("platform")
	val platform: Platform
)