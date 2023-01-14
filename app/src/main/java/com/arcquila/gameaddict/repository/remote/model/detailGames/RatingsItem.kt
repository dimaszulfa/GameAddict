package com.arcquila.gameaddict.repository.remote.model.detailGames

import com.google.gson.annotations.SerializedName

data class RatingsItem(

	@field:SerializedName("count")
	val count: Int,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("percent")
	val percent: Any
)