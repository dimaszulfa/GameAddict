package com.arcquila.gameaddict.repository.remote.model

import com.arcquila.gameaddict.domain.Game
import com.google.gson.annotations.SerializedName

data class GamesResponse(

    @field:SerializedName("next")
	val next: String,

    @field:SerializedName("nofollow")
	val nofollow: Boolean,

    @field:SerializedName("noindex")
	val noindex: Boolean,

    @field:SerializedName("nofollow_collections")
	val nofollowCollections: List<String>,

    @field:SerializedName("previous")
	val previous: Any,

    @field:SerializedName("count")
	val count: Int,

    @field:SerializedName("description")
	val description: String,

    @field:SerializedName("seo_h1")
	val seoH1: String,

    @field:SerializedName("filters")
	val filters: Filters,

    @field:SerializedName("seo_title")
	val seoTitle: String,

    @field:SerializedName("seo_description")
	val seoDescription: String,

    @field:SerializedName("results")
	val results: List<ResultsItem>,

    @field:SerializedName("seo_keywords")
	val seoKeywords: String
){
    fun getGames(): List<Game>{
        return results?.map {
            it.toGame()
        }.orEmpty()
    }
}