package ru.apshheko.ttvicuesoft.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.apshheko.baseapp.di.AppScope
import ru.apshheko.baseapp.di.BaseFeature
import ru.apshheko.baseapp.di.BaseFeatureApi
import ru.apshheko.ttvicuesoft.di.features.DaggerVideoPlayerScreenExportComponent
import ru.apshheko.video_player_screen.di.VideoPlayerScreenDependencies
import ru.apshheko.video_player_screen.di.VideoPlayerScreenFeature
import ru.apshheko.video_player_screen.di.VideoPlayerScreenFeatureApi
import javax.inject.Provider
import javax.inject.Scope

@Module
class AppModule(private val appContext: Context) {
    @AppScope
    @Provides
    fun provideContext(): Context = appContext

    @Provides
    @AppScope
    fun provideFirstInitFeatures(modules: Provider<Set<BaseFeature<*, *>>>): List<BaseFeatureApi> {
        return modules.get()
            .map { it.getApi() }
            .toList()
    }

    @Provides
    @AppScope
    fun provideVideoPlayerScreenDependencies(): VideoPlayerScreenDependencies {
        return DaggerVideoPlayerScreenExportComponent.builder().build()
    }

    @Provides
    @AppScope
    fun provideVideoPlayerScreenFeatureApi(feature: VideoPlayerScreenFeature): VideoPlayerScreenFeatureApi {
        return feature.getApi()
    }
}