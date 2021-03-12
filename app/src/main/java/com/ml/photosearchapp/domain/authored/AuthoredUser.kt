package com.ml.photosearchapp.domain.authored

import com.google.gson.annotations.SerializedName
import com.ml.photosearchapp.domain.Links
import com.ml.photosearchapp.domain.ProfileImage

data class AuthoredUser(
    @SerializedName("id") val id: String,
    @SerializedName("username") val username: String,
    @SerializedName("name") val name: String,
    @SerializedName("portfolio_url") val portfolio_url: String,
    @SerializedName("bio") val bio: String,
    @SerializedName("location") val location: String,
    @SerializedName("total_likes") val total_likes: Int,
    @SerializedName("total_photos") val total_photos: Int,
    @SerializedName("total_collections") val total_collections: Int,
    @SerializedName("instagram_username") val instagram_username: String,
    @SerializedName("twitter_username") val twitter_username: String,
    @SerializedName("profile_image") val profile_image: ProfileImage,
    @SerializedName("links") val links: Links
)