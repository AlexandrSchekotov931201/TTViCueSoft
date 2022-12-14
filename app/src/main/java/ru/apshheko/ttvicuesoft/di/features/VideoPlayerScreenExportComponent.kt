package ru.apshheko.ttvicuesoft.di.features

import dagger.Component
import ru.apshheko.network_api.di.NetworkFeatureApi
import ru.apshheko.video_player_screen.di.VideoPlayerScreenDependencies
import ru.apshheko.video_player_screen.di.VideoPlayerScreenFeatureApi

@Component(dependencies = [
    NetworkFeatureApi::class
])
interface VideoPlayerScreenExportComponent : VideoPlayerScreenDependencies