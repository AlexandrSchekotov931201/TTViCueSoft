package ru.apshheko.video_player_screen.data.api.response

import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("file_url") val fileUrl: String?,
    @SerializedName("small_poster_url") val smallPosterUrl: String?
)
