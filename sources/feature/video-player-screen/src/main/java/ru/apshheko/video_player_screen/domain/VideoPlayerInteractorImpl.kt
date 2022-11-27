package ru.apshheko.video_player_screen.domain

import ru.apshheko.video_player_screen.data.VideoPlayerRepository
import ru.apshheko.video_player_screen.domain.mapper.VideoPlayerScreenMapperDomain
import ru.apshheko.video_player_screen.domain.model.VideoPlayerScreenModelDomain
import javax.inject.Inject

class VideoPlayerInteractorImpl @Inject constructor(
    private val repository: VideoPlayerRepository,
    private val mapper: VideoPlayerScreenMapperDomain
): VideoPlayerInteractor {
    override suspend fun getVideo(): List<VideoPlayerScreenModelDomain> {
        return mapper.map(repository.getVideo())
    }
}