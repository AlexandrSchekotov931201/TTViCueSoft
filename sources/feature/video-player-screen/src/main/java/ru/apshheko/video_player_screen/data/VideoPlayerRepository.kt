package ru.apshheko.video_player_screen.data

import ru.apshheko.network_api.api.response.VideoResponse

interface VideoPlayerRepository {
    suspend fun getVideo(): List<VideoResponse>?
}