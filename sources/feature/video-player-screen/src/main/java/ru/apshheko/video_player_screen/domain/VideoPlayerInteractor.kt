package ru.apshheko.video_player_screen.domain

import ru.apshheko.video_player_screen.domain.model.VideoPlayerScreenModelDomain

interface VideoPlayerInteractor {
    suspend fun getVideo(): List<VideoPlayerScreenModelDomain>
}