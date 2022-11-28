package ru.apshheko.ttvicuesoft.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet
import ru.apshheko.baseapp.di.BaseFeature
import ru.apshheko.network_impl.di.NetworkFeature
import ru.apshheko.video_player_screen.di.VideoPlayerScreenFeature

@Module
abstract class BaseFeatureModule {
    @Binds
    @IntoSet
    abstract fun bindVideoPlayerScreenFeature(a: VideoPlayerScreenFeature): BaseFeature<*, *>

    @Binds
    @IntoSet
    abstract fun bindNetworkFeature(a: NetworkFeature): BaseFeature<*, *>
}