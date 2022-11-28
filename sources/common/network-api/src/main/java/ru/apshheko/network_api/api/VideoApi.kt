package ru.apshheko.network_api.api

import retrofit2.Response
import retrofit2.http.GET
import ru.apshheko.network_api.api.response.VideoResponse

interface VideoApi {
    @GET("/api/backgrounds/?group=video&category_id=1")
    suspend fun getVideo(): Response<List<VideoResponse>>
}