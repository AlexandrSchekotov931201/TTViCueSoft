package ru.apshheko.network_impl.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.apshheko.baseapp.di.PerFeature
import ru.apshheko.network_api.api.VideoApi
import ru.apshheko.network_impl.config.NetworkConfig.CALL_TIMEOUT
import ru.apshheko.network_impl.config.NetworkConfig.CONNECTION_TIMEOUT
import ru.apshheko.network_impl.config.NetworkConfig.READ_TIMEOUT
import ru.apshheko.network_impl.config.NetworkConfig.WRITE_TIMEOUT
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    @Provides
    @PerFeature
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .callTimeout(CALL_TIMEOUT, TimeUnit.MILLISECONDS)
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            .build()
    }

    @Provides
    @PerFeature
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dev.bgrem.deelvin.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @PerFeature
    fun provideVideoApi(retrofit: Retrofit): VideoApi {
        return retrofit.create(VideoApi::class.java)
    }

}