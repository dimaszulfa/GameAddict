package com.arcquila.gameaddict.repository.remote.model

import com.google.gson.annotations.SerializedName

data class EsrbRating(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("slug")
	val slug: String
)