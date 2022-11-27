package ru.apshheko.video_player_screen.domain

import ru.apshheko.video_player_screen.data.VideoPlayerRepository
import javax.inject.Inject

class VideoPlayerInteractorImpl @Inject constructor(
    private val videoPlayerRepository: VideoPlayerRepository
): VideoPlayerInteractor {

}