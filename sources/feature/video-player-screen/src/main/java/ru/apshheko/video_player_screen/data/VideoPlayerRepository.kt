package ru.apshheko.video_player_screen.data

import ru.apshheko.video_player_screen.data.api.response.VideoResponse

interface VideoPlayerRepository {
    suspend fun getVideo(): List<VideoResponse>?
}