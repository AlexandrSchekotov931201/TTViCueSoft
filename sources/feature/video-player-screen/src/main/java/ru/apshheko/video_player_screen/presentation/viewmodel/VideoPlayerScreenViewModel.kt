package ru.apshheko.video_player_screen.presentation.viewmodel

import androidx.lifecycle.ViewModel
import ru.apshheko.video_player_screen.domain.VideoPlayerInteractor
import javax.inject.Inject

class VideoPlayerScreenViewModel @Inject constructor(
    private val videoPlayerInteractor: VideoPlayerInteractor
): ViewModel() {



}