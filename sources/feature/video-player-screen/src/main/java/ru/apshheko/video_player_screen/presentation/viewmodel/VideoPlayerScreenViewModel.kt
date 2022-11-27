package ru.apshheko.video_player_screen.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.apshheko.video_player_screen.domain.VideoPlayerInteractor
import ru.apshheko.video_player_screen.presentation.mapper.VideoPlayerScreenMapper
import ru.apshheko.video_player_screen.presentation.model.Poster
import ru.apshheko.video_player_screen.presentation.model.VideoPlayerScreenModel
import ru.apshheko.video_player_screen.presentation.state.UiEffect
import ru.apshheko.video_player_screen.presentation.state.UiState
import javax.inject.Inject

class VideoPlayerScreenViewModel @Inject constructor(
    private val interactor: VideoPlayerInteractor,
    private val mapper: VideoPlayerScreenMapper
) : ViewModel() {

    private val uiState = MutableStateFlow<UiState>(UiState.Initialization)
    private val uiEffect = MutableSharedFlow<UiEffect>()
    private var posters: List<Poster>? = null

    fun getVideoPlayerScreenState(): StateFlow<UiState> = uiState.asStateFlow()
    fun getVideoPlayerScreenEffect(): SharedFlow<UiEffect> = uiEffect.asSharedFlow()

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    fun onCreate() {
        viewModelScope.launch {
            dispatchState(UiState.VideoPlayerScreen(
                mapper.map(interactor.getVideo()).also { posters = it.posters }
            ))
        }
    }

    fun onClickPoster(fileUrl: String) {
        posters?.let {
            dispatchState(UiState.VideoPlayerScreen(VideoPlayerScreenModel(fileUrl, it)))
        }
    }

    private fun dispatchState(state: UiState) {
        uiState.value = state
    }

    private fun dispatchEffect(effect: UiEffect) {
        viewModelScope.launch {
            uiEffect.emit(effect)
        }
    }
}