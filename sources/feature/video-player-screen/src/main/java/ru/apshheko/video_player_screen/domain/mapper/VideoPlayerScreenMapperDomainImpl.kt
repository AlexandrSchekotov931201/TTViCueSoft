package ru.apshheko.video_player_screen.domain.mapper

import ru.apshheko.video_player_screen.data.api.response.VideoResponse
import ru.apshheko.video_player_screen.domain.model.VideoPlayerScreenModelDomain
import javax.inject.Inject

class VideoPlayerScreenMapperDomainImpl @Inject constructor(): VideoPlayerScreenMapperDomain {
    override fun map(listModel: List<VideoResponse>?): List<VideoPlayerScreenModelDomain> {
        return listModel?.map {
            VideoPlayerScreenModelDomain(
                it.fileUrl.orEmpty(),
                it.smallPosterUrl.orEmpty()
            )
        }?: listOf()
    }
}