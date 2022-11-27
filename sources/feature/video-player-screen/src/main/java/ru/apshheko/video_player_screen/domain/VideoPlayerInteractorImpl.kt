package ru.apshheko.video_player_screen.domain

import javax.inject.Inject

class VideoPlayerInteractorImpl @Inject constructor(): VideoPlayerInteractor {
    override fun test() {
        println("Удачный тест")
    }
}