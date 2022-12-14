package ru.apshheko.video_player_screen.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.StyledPlayerView
import ru.apshheko.designsystem.Gray
import ru.apshheko.designsystem.ext.dpToPx
import ru.apshheko.designsystem.view.GlideImage
import ru.apshheko.video_player_screen.presentation.model.VideoPlayerScreenModel
import kotlin.math.roundToInt

@Composable
fun VideoPlayerScreenView(
    videoPlayerScreenModel: VideoPlayerScreenModel,
    onClickPoster: (fileUrl: String) -> Unit
) {
    var sizeVideoPlayer: IntSize? = null
    var sizeTextField: IntSize? = null
    var textField by remember { mutableStateOf("")}
    val offSetPadding = LocalContext.current.dpToPx(8).toFloat()
    var offsetX by remember { mutableStateOf(offSetPadding) }
    var offsetY by remember { mutableStateOf(0f) }
    var isShowTextField by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Box {
                AndroidView(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                        .fillMaxWidth()
                        .height(208.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .onGloballyPositioned {
                            sizeVideoPlayer = it.size
                        },
                    factory = { context ->
                        StyledPlayerView(context).apply {
                            resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
                            player = ExoPlayer.Builder(context).build()
                            player?.apply {
                                repeatMode = Player.REPEAT_MODE_ONE
                                useController = false
                                addMediaItem(MediaItem.fromUri(videoPlayerScreenModel.fileUrlForShow))
                                prepare()
                                play()
                            }
                        }
                    },
                    update = { view ->
                        view.apply {
                            player?.apply {
                                val mediaItem = MediaItem.fromUri(videoPlayerScreenModel.fileUrlForShow)
                                if (mediaItem != this.currentMediaItem) {
                                    stop()
                                    repeat(mediaItemCount) {
                                        removeMediaItem(it)
                                    }
                                    addMediaItem(MediaItem.fromUri(videoPlayerScreenModel.fileUrlForShow))
                                    prepare()
                                    play()
                                }
                            }
                        }
                    }
                )
                if (isShowTextField) {
                    TextField(
                        modifier = Modifier
                            .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                            .pointerInput(Unit) {
                                detectDragGestures { change, dragAmount ->
                                    change.consume()
                                    val maxYVideoPlayer = sizeVideoPlayer?.height ?: 0
                                    val maxXVideoPlayer = sizeVideoPlayer?.width ?: 0
                                    val maxYTextField = sizeTextField?.height ?: 0
                                    val maxXTextField = sizeTextField?.width ?: 0
                                    if ((offsetX + dragAmount.x) > 0 + offSetPadding && (offsetX + dragAmount.x) < maxXVideoPlayer - maxXTextField + offSetPadding) {
                                        offsetX += dragAmount.x
                                    }
                                    if ((offsetY + dragAmount.y) > 0 && (offsetY + dragAmount.y) < maxYVideoPlayer - maxYTextField) {
                                        offsetY += dragAmount.y
                                    }
                                }
                            }
                            .onGloballyPositioned {
                                sizeTextField = it.size
                            },
                        value = textField,
                        onValueChange = { textField = it}
                    )
                }
            }
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 44.dp)
                    .size(144.dp, 46.dp),
                onClick = { isShowTextField = !isShowTextField}
            ) {
                Text(text = "TEXT")
            }
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            Box(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .height(84.dp)
                    .background(Gray)
            ) {
                LazyRow(
                    modifier = Modifier.align(Alignment.Center),
                ) {
                    items(videoPlayerScreenModel.posters) { item ->
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
    }
}