package com.ml.photosearchapp.domain

import com.google.gson.annotations.SerializedName

data class Links (
	@SerializedName("self") val self : String,
	@SerializedName("html") val html : String,
	@SerializedName("photos") val photos : String,
	@SerializedName("likes") val likes : String
)
