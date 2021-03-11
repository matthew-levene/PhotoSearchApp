package com.ml.photosearchapp.domain

import com.google.gson.annotations.SerializedName

data class User (
	@SerializedName("id") val id : String,
	@SerializedName("username") val username : String,
	@SerializedName("name") val name : String,
	@SerializedName("links") val links : Links
)
