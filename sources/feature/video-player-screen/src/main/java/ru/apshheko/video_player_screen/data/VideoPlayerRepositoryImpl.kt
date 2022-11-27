package ru.apshheko.video_player_screen.data

import ru.apshheko.video_player_screen.data.api.RequestApi
import ru.apshheko.video_player_screen.data.api.response.VideoResponse
import javax.inject.Inject

class VideoPlayerRepositoryImpl @Inject constructor(
    private val requestApi: RequestApi
) : VideoPlayerRepository{
    override suspend fun getVideo(): List<VideoResponse>? {
        return requestApi.getVideo().body()
    }
}