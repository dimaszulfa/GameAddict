package com.arcquila.gameaddict.repository.remote.model

import com.google.gson.annotations.SerializedName

data class ShortScreenshotsItem(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("id")
	val id: Int
)