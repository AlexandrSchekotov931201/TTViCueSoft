package ru.apshheko.video_player_screen.domain

import ru.apshheko.video_player_screen.data.VideoPlayerRepository
import ru.apshheko.video_player_screen.data.api.response.VideoResponse
import javax.inject.Inject

class VideoPlayerInteractorImpl @Inject constructor(
    private val videoPlayerRepository: VideoPlayerRepository
): VideoPlayerInteractor {
    override suspend fun getVideo(): List<VideoResponse>? {
        return videoPlayerRepository.getVideo()
    }
}