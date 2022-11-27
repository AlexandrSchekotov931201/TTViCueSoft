package ru.apshheko.video_player_screen.presentation.mapper

import ru.apshheko.video_player_screen.domain.model.VideoPlayerScreenModelDomain
import ru.apshheko.video_player_screen.presentation.model.Poster
import ru.apshheko.video_player_screen.presentation.model.VideoPlayerScreenModel
import javax.inject.Inject

class VideoPlayerScreenMapperImpl @Inject constructor() : VideoPlayerScreenMapper {
    override fun map(listModel: List<VideoPlayerScreenModelDomain>): VideoPlayerScreenModel {
        val firstFileUrl = listModel.first().fileUrl
        val posters = listModel.map { Poster(it.fileUrl, it.smallPosterUrl) }
        return VideoPlayerScreenModel(
            firstFileUrl,
            posters
        )
    }
}