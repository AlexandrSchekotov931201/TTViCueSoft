package ru.apshheko.video_player_screen.di

import ru.apshheko.baseapp.di.AppScope
import ru.apshheko.baseapp.di.BaseDependencies
import ru.apshheko.baseapp.di.BaseFeature
import ru.apshheko.baseapp.di.BaseFeatureApi
import ru.apshheko.network_api.di.NetworkFeatureApi
import javax.inject.Inject
import javax.inject.Provider

interface VideoPlayerScreenDependencies : BaseDependencies, NetworkFeatureApi
interface VideoPlayerScreenFeatureApi : BaseFeatureApi

@AppScope
class VideoPlayerScreenFeature @Inject constructor(
    dependencies: Provider<VideoPlayerScreenDependencies>
) : BaseFeature<VideoPlayerScreenFeatureApi, VideoPlayerScreenDependencies>(dependencies) {
    private val _api: VideoPlayerScreenFeatureApi by lazy {
        DaggerVideoPlayerScreenComponent.builder()
            .videoPlayerScreenDependencies(dependencies.get())
            .build()
            .also { videoPlayerScreenComponent = it }
    }

    override fun getApi(): VideoPlayerScreenFeatureApi = _api

    companion object {
        internal var videoPlayerScreenComponent: VideoPlayerScreenComponent? = null
    }
}