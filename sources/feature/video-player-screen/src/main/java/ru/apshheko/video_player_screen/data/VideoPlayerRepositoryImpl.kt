package ru.apshheko.video_player_screen.data

import ru.apshheko.network_api.api.VideoApi
import ru.apshheko.network_api.api.response.VideoResponse
import javax.inject.Inject

class VideoPlayerRepositoryImpl @Inject constructor(
    private val api: VideoApi
) : VideoPlayerRepository{
    override suspend fun getVideo(): List<VideoResponse>? {
        return api.getVideo().body()
    }
}