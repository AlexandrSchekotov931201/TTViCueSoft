package ru.apshheko.video_player_screen.di

import dagger.Component
import ru.apshheko.baseapp.di.PerFeature
import ru.apshheko.video_player_screen.presentation.view.MainActivity

@PerFeature
@Component(modules = [VideoPlayerScreenModule::class], dependencies = [VideoPlayerScreenDependencies::class])
interface VideoPlayerScreenComponent : VideoPlayerScreenFeatureApi {
    fun inject(activity: MainActivity)
}