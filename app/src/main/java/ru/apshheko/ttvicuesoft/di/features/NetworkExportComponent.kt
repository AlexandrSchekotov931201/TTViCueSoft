package ru.apshheko.ttvicuesoft.di.features

import dagger.Component
import ru.apshheko.network_impl.di.NetworkDependencies
import ru.apshheko.video_player_screen.di.VideoPlayerScreenDependencies
import ru.apshheko.video_player_screen.di.VideoPlayerScreenFeatureApi

@Component
interface NetworkExportComponent : NetworkDependencies