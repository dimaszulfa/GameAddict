package com.arcquila.gameaddict.repository.remote.model.detailGames

import com.google.gson.annotations.SerializedName

data class AddedByStatus(

	@field:SerializedName("owned")
	val owned: Int,

	@field:SerializedName("beaten")
	val beaten: Int,

	@field:SerializedName("dropped")
	val dropped: Int,

	@field:SerializedName("yet")
	val yet: Int,

	@field:SerializedName("playing")
	val playing: Int,

	@field:SerializedName("toplay")
	val toplay: Int
)