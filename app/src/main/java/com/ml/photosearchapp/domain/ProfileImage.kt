package com.ml.photosearchapp.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProfileImage(

	@SerializedName("small") val small: String,
	@SerializedName("medium") val medium: String,
	@SerializedName("large") val large: String
) : Serializable