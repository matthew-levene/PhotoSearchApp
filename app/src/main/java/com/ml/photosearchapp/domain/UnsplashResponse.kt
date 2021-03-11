package com.ml.photosearchapp.domain

import com.google.gson.annotations.SerializedName

data class UnsplashResponse (
	@SerializedName("photo") val photo : Photo,
	@SerializedName("user") val user : User
)
