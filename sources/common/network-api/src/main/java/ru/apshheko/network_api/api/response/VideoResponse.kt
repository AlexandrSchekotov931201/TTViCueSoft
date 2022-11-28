package ru.apshheko.network_api.api.response

import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("file_url") val fileUrl: String?,
    @SerializedName("small_poster_url") val smallPosterUrl: String?
)
