package ru.apshheko.video_player_screen.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.StyledPlayerView
import ru.apshheko.designsystem.Gray
import ru.apshheko.designsystem.view.GlideImage
import ru.apshheko.video_player_screen.presentation.model.Poster
import ru.apshheko.video_player_screen.presentation.model.VideoPlayerScreenModel

@Composable
fun VideoPlayerScreenView(
    videoPlayerScreenModel: VideoPlayerScreenModel,
    onClickPoster: (fileUrl: String) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            VideoPlayer(videoPlayerScreenModel.fileUrlForShow)
            ButtonView(Modifier.align(Alignment.CenterHorizontally))
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            Posters(videoPlayerScreenModel.posters, onClickPoster)
        }
    }
}

@Composable
private fun VideoPlayer(fileUrl: String) {
    AndroidView(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
            .fillMaxWidth()
            .height(208.dp)
            .clip(RoundedCornerShape(15.dp)),
        factory = { context ->
            StyledPlayerView(context).apply {
                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
                player = ExoPlayer.Builder(context).build()
                player?.apply {
                    repeatMode = Player.REPEAT_MODE_ONE
                    useController = false
                    addMediaItem(MediaItem.fromUri(fileUrl))
                    prepare()
                    play()
                }
            }
        },
        update = { view ->
            view.apply {
                player?.apply {
                    stop()
                    repeat(mediaItemCount) {
                        removeMediaItem(it)
                    }
                    addMediaItem(MediaItem.fromUri(fileUrl))
                    prepare()
                    play()
                }
            }
        }
    )
}

@Composable
private fun ButtonView(modifier: Modifier) {
    Button(
        modifier = modifier
            .padding(top = 44.dp)
            .size(144.dp, 46.dp),
        onClick = {}
    ) {
        Text(text = "TEXT")
    }
}

@Composable
private fun Posters(posters: List<Poster>, onClickPoster: (fileUrl: String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(top = 24.dp)
            .height(84.dp)
            .background(Gray)
    ) {
        LazyRow(
            modifier = Modifier.align(Alignment.Center),
        ) {
            items(posters) { item ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .size(70.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .clickable { onClickPoster.invoke(item.fileUrl) }
                ) {
                    GlideImage(
                        url = item.posterUrl
                    )
                }
            }
        }
    }
}