package com.arcquila.gameaddict.repository.remote.model

import com.google.gson.annotations.SerializedName

data class RequirementsRu(

	@field:SerializedName("minimum")
	val minimum: String,

	@field:SerializedName("recommended")
	val recommended: String
)