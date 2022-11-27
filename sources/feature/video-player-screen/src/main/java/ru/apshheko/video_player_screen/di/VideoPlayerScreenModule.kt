package ru.apshheko.video_player_screen.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.apshheko.baseapp.di.PerFeature
import ru.apshheko.baseapp.di.ViewModelFactory
import ru.apshheko.baseapp.di.ViewModelKey
import ru.apshheko.video_player_screen.data.VideoPlayerRepository
import ru.apshheko.video_player_screen.data.VideoPlayerRepositoryImpl
import ru.apshheko.video_player_screen.data.api.RequestApi
import ru.apshheko.video_player_screen.domain.VideoPlayerInteractor
import ru.apshheko.video_player_screen.domain.VideoPlayerInteractorImpl
import ru.apshheko.video_player_screen.presentation.viewmodel.VideoPlayerScreenViewModel

@Module
abstract class VideoPlayerScreenModule {
    @Binds
    @IntoMap
    @ViewModelKey(VideoPlayerScreenViewModel::class)
    abstract fun bindVideoPlayerScreenViewModel(bind: VideoPlayerScreenViewModel): ViewModel

    @Binds
    @PerFeature
    abstract fun bindVideoPlayerInteractor(bind: VideoPlayerInteractorImpl): VideoPlayerInteractor

    @Binds
    @PerFeature
    abstract fun bindVideoPlayerRepository(bind: VideoPlayerRepositoryImpl): VideoPlayerRepository

    @Binds
    abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    companion object {

        @Provides
        @PerFeature
        fun provideOkHttp(): OkHttpClient {
            return OkHttpClient.Builder().build()
        }

        @Provides
        @PerFeature
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://dev.bgrem.deelvin.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @PerFeature
        fun provideRequestApi(retrofit: Retrofit): RequestApi {
            return retrofit.create(RequestApi::class.java)
        }

    }

}