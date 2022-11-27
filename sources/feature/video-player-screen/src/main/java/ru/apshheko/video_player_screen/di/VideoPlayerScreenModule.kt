package ru.apshheko.video_player_screen.di

import dagger.Binds
import dagger.Module
import ru.apshheko.baseapp.di.PerFeature
import ru.apshheko.video_player_screen.domain.VideoPlayerInteractor
import ru.apshheko.video_player_screen.domain.VideoPlayerInteractorImpl

@Module
abstract class VideoPlayerScreenModule {

    @PerFeature
    @Binds
    abstract fun bindVideoPlayerInteractor(bind: VideoPlayerInteractorImpl): VideoPlayerInteractor

}