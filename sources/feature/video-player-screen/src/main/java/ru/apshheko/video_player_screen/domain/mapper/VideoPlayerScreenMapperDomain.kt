package ru.apshheko.video_player_screen.domain.mapper

import ru.apshheko.video_player_screen.data.api.response.VideoResponse
import ru.apshheko.video_player_screen.domain.model.VideoPlayerScreenModelDomain

interface VideoPlayerScreenMapperDomain {
    fun map(listModel: List<VideoResponse>?): List<VideoPlayerScreenModelDomain>
}