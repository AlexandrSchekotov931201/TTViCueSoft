package ru.apshheko.ttvicuesoft.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.apshheko.baseapp.di.AppScope
import ru.apshheko.baseapp.di.BaseFeature
import ru.apshheko.baseapp.di.BaseFeatureApi
import ru.apshheko.network_api.di.NetworkFeatureApi
import ru.apshheko.network_impl.di.NetworkDependencies
import ru.apshheko.network_impl.di.NetworkFeature
import ru.apshheko.ttvicuesoft.di.features.DaggerNetworkExportComponent
import ru.apshheko.ttvicuesoft.di.features.DaggerVideoPlayerScreenExportComponent
import ru.apshheko.video_player_screen.di.VideoPlayerScreenDependencies
import ru.apshheko.video_player_screen.di.VideoPlayerScreenFeature
import ru.apshheko.video_player_screen.di.VideoPlayerScreenFeatureApi
import javax.inject.Provider

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
    fun provideVideoPlayerScreenDependencies(networkFeatureApi: NetworkFeatureApi): VideoPlayerScreenDependencies {
        return DaggerVideoPlayerScreenExportComponent.builder()
            .networkFeatureApi(networkFeatureApi)
            .build()
    }

    @Provides
    @AppScope
    fun provideVideoPlayerScreenFeatureApi(feature: VideoPlayerScreenFeature): VideoPlayerScreenFeatureApi {
        return feature.getApi()
    }

    @Provides
    @AppScope
    fun provideNetworkDependencies(): NetworkDependencies {
        return DaggerNetworkExportComponent.builder().build()
    }

    @Provides
    @AppScope
    fun provideNetworkFeatureApi(feature: NetworkFeature): NetworkFeatureApi {
        return feature.getApi()
    }
}