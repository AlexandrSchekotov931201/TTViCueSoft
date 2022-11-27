package ru.apshheko.video_player_screen.presentation.state

sealed class UiState {
    object Initialization: UiState()
    class VideoPlayerScreen(val fileUrl: String, val postersUrl: List<String>): UiState()
}
