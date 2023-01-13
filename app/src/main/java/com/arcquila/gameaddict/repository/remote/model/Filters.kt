package com.arcquila.gameaddict.repository.remote.model

import com.google.gson.annotations.SerializedName

data class Filters(

	@field:SerializedName("years")
	val years: List<YearsItem>
)