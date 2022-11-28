package ru.apshheko.video_player_screen.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.apshheko.baseapp.di.PerFeature
import ru.apshheko.baseapp.di.ViewModelFactory
import ru.apshheko.baseapp.di.ViewModelKey
import ru.apshheko.video_player_screen.data.VideoPlayerRepository
import ru.apshheko.video_player_screen.data.VideoPlayerRepositoryImpl
import ru.apshheko.video_player_screen.domain.VideoPlayerInteractor
import ru.apshheko.video_player_screen.domain.VideoPlayerInteractorImpl
import ru.apshheko.video_player_screen.domain.mapper.VideoPlayerScreenMapperDomain
import ru.apshheko.video_player_screen.domain.mapper.VideoPlayerScreenMapperDomainImpl
import ru.apshheko.video_player_screen.presentation.mapper.VideoPlayerScreenMapper
import ru.apshheko.video_player_screen.presentation.mapper.VideoPlayerScreenMapperImpl
import ru.apshheko.video_player_screen.presentation.viewmodel.VideoPlayerScreenViewModel

@Module
abstract class VideoPlayerScreenModule {

    @Binds
    @PerFeature
    abstract fun bindVideoPlayerInteractor(bind: VideoPlayerInteractorImpl): VideoPlayerInteractor

    @Binds
    @PerFeature
    abstract fun bindVideoPlayerRepository(bind: VideoPlayerRepositoryImpl): VideoPlayerRepository

    @Binds
    @PerFeature
    abstract fun bindVideoPlayerScreenMapperDomain(bind: VideoPlayerScreenMapperDomainImpl): VideoPlayerScreenMapperDomain

    @Binds
    @PerFeature
    abstract fun bindVideoPlayerScreenMapper(bind: VideoPlayerScreenMapperImpl): VideoPlayerScreenMapper

    @Binds
    abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(VideoPlayerScreenViewModel::class)
    abstract fun bindVideoPlayerScreenViewModel(bind: VideoPlayerScreenViewModel): ViewModel

}