package ru.apshheko.video_player_screen.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.apshheko.video_player_screen.domain.VideoPlayerInteractor
import ru.apshheko.video_player_screen.presentation.state.UiState
import javax.inject.Inject

class VideoPlayerScreenViewModel @Inject constructor(
    private val videoPlayerInteractor: VideoPlayerInteractor
): ViewModel() {

    private val state = MutableStateFlow<UiState>(UiState.Initialization)

    fun getVideoPlayerScreenState(): StateFlow<UiState> = state.asStateFlow()

    fun onCreate() {
        viewModelScope.launch {
            val result = videoPlayerInteractor.getVideo()
            val firsVideo = result?.first()?.fileUrl.orEmpty()
            dispatchState(UiState.VideoPlayerScreen(firsVideo, listOf()))
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    private fun dispatchState(state: UiState) {
        this.state.value = state
    }
}