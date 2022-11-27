package ru.apshheko.video_player_screen.presentation.mapper

import ru.apshheko.video_player_screen.domain.model.VideoPlayerScreenModelDomain
import ru.apshheko.video_player_screen.presentation.model.VideoPlayerScreenModel

interface VideoPlayerScreenMapper {
    fun map(listModel: List<VideoPlayerScreenModelDomain>): VideoPlayerScreenModel
}