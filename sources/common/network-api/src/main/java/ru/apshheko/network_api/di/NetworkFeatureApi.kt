package ru.apshheko.network_api.di

import ru.apshheko.baseapp.di.BaseFeatureApi
import ru.apshheko.network_api.api.VideoApi

interface NetworkFeatureApi : BaseFeatureApi {
    fun getVideoApi(): VideoApi
}