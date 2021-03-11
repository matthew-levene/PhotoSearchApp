package com.ml.photosearchapp.domain

import com.google.gson.annotations.SerializedName

data class Photo (
	@SerializedName("id") val id : String,
	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int,
	@SerializedName("color") val color : String,
	@SerializedName("blur_hash") val blur_hash : String,
	@SerializedName("likes") val likes : Int,
	@SerializedName("liked_by_user") val liked_by_user : Boolean,
	@SerializedName("description") val description : String,
	@SerializedName("urls") val urls : Urls,
	@SerializedName("links") val links : Links
)
