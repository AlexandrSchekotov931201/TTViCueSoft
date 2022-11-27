package ru.apshheko.video_player_screen.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import ru.apshheko.designsystem.ComposeActivityTheme
import ru.apshheko.video_player_screen.di.VideoPlayerScreenFeature
import ru.apshheko.video_player_screen.presentation.state.UiEffect
import ru.apshheko.video_player_screen.presentation.state.UiState
import ru.apshheko.video_player_screen.presentation.viewmodel.VideoPlayerScreenViewModel
import javax.inject.Inject

class VideoPlayerScreen : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: VideoPlayerScreenViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        VideoPlayerScreenFeature.videoPlayerScreenComponent?.inject(this)
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.getVideoPlayerScreenState().collect { state ->
                    setContent {
                        ComposeActivityTheme {
                            SetVideoPlayerScreenState(state)
                        }
                    }
                }
            }
        }
        viewModel.onCreate()
    }

    @Composable
    private fun SetVideoPlayerScreenState(state: UiState) {
        when (state) {
            is UiState.Initialization -> {}
            is UiState.VideoPlayerScreen -> VideoPlayerScreenView(
                videoPlayerScreenModel = state.videoPlayerScreenModel,
                onClickPoster = { viewModel.onClickPoster(it) }
            )
        }
    }
}