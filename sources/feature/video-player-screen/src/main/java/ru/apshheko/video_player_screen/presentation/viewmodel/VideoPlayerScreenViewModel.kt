package ru.apshheko.video_player_screen.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.apshheko.video_player_screen.domain.VideoPlayerInteractor
import javax.inject.Inject

class VideoPlayerScreenViewModel @Inject constructor(
    private val videoPlayerInteractor: VideoPlayerInteractor
): ViewModel() {

    fun onCreate() {
        viewModelScope.launch {
            val result = videoPlayerInteractor.getVideo()
            result?.forEach {
                println(it.smallPosterUrl)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}