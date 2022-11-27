package ru.apshheko.video_player_screen.presentation.model

class VideoPlayerScreenModel(
    val fileUrlForShow: String,
    val posters: List<Poster>
)

class Poster(
    val fileUrl: String,
    val posterUrl: String
)