package ru.apshheko.video_player_screen.domain

import ru.apshheko.video_player_screen.data.api.response.VideoResponse

interface VideoPlayerInteractor {
    suspend fun getVideo(): List<VideoResponse>?
}