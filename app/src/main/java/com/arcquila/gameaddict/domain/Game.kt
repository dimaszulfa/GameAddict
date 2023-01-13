package com.arcquila.gameaddict.domain

import com.arcquila.gameaddict.repository.remote.model.*
import com.google.gson.annotations.SerializedName

data class Game(
    val id: String,
    val name: String,
    val backgroundImage: String,
    val released: String,
    val rating: String,
)
