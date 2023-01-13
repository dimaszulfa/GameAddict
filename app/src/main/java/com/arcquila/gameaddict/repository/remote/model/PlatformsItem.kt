package com.arcquila.gameaddict.repository.remote.model

import com.google.gson.annotations.SerializedName

data class PlatformsItem(

	@field:SerializedName("requirements_ru")
	val requirementsRu: Any,

	@field:SerializedName("requirements_en")
	val requirementsEn: Any,

	@field:SerializedName("released_at")
	val releasedAt: String,

	@field:SerializedName("platform")
	val platform: Platform
)