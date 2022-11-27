package ru.apshheko.video_player_screen.data.api

import retrofit2.Response
import retrofit2.http.GET
import ru.apshheko.video_player_screen.data.api.response.VideoResponse

interface RequestApi {
    @GET("/api/backgrounds/?group=video&category_id=1")
    suspend fun getVideo(): Response<List<VideoResponse>>
}