package ru.apshheko.video_player_screen.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.StyledPlayerView
import ru.apshheko.baseapp.di.BaseFeature
import ru.apshheko.designsystem.ComposeActivityTheme
import ru.apshheko.video_player_screen.di.VideoPlayerScreenFeature
import ru.apshheko.video_player_screen.domain.VideoPlayerInteractor
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @set:Inject
    var interactor: VideoPlayerInteractor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        VideoPlayerScreenFeature.videoPlayerScreenComponent?.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            ComposeActivityTheme {
                Column {
                    VideoPlayer(
                        Modifier
                            .padding(start = 8.dp, end = 8.dp, top = 167.dp)
                            .fillMaxWidth()
                            .height(208.dp)
                            .clip(RoundedCornerShape(15.dp))
                    )
                    Button(
                        Modifier
                            .padding(top = 44.dp)
                            .size(144.dp, 46.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Posters(
                        listOf("One", "Two", "Three", "Four", "Five", "Six", "Seven"),
                        Modifier
                            .padding(top = 24.dp)
                            .height(360.dp)
                            .background(Color.Gray)
                    )
                }
            }
        }
    }
}

@Composable
fun VideoPlayer(modifier: Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            StyledPlayerView(context).apply {
                player = ExoPlayer.Builder(context).build()
            }
        })
}

@Composable
fun Button(modifier: Modifier) {
    Button(
        modifier = modifier,
        onClick = {}
    ) {
        Text(text = "TEXT")
    }
}

@Composable
fun Posters(itemsDammy: List<String>, modifier: Modifier) {
    Box(modifier = modifier) {
        LazyRow(
            modifier = Modifier.align(Alignment.Center),
        ) {
            itemsIndexed(itemsDammy) { index, item ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clip(RoundedCornerShape(5.dp))
                ) {
                    Text(
                        modifier = Modifier
                            .size(70.dp, 70.dp)
                            .background(Color.Black),
                        text = item
                    )
                }
            }
        }
    }
}