package ru.apshheko.video_player_screen.presentation.view

import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.StyledPlayerView

@Composable
fun VideoPlayerScreenView(
    fileUrl: String
) {
    Column {
        VideoPlayer(
            fileUrl,
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

@Composable
private fun VideoPlayer(fileUrl: String, modifier: Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            StyledPlayerView(context).apply {
                player = ExoPlayer.Builder(context).build()
                player?.apply {
                    repeatMode = Player.REPEAT_MODE_ONE
                    useController = false
                    addMediaItem(MediaItem.fromUri(fileUrl))
                    prepare()
                    play()
                }
            }
        })
}

@Composable
private fun Button(modifier: Modifier) {
    androidx.compose.material.Button(
        modifier = modifier,
        onClick = {}
    ) {
        Text(text = "TEXT")
    }
}

@Composable
private fun Posters(itemsDammy: List<String>, modifier: Modifier) {
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