package ru.apshheko.video_player_screen.presentation.state

import ru.apshheko.video_player_screen.presentation.model.VideoPlayerScreenModel

sealed class UiState {
    object Initialization: UiState()
    class VideoPlayerScreen(val videoPlayerScreenModel: VideoPlayerScreenModel): UiState()
}
