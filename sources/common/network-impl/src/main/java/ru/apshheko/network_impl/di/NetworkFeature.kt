package ru.apshheko.network_impl.di

import ru.apshheko.baseapp.di.AppScope
import ru.apshheko.baseapp.di.BaseDependencies
import ru.apshheko.baseapp.di.BaseFeature
import ru.apshheko.network_api.di.NetworkFeatureApi
import javax.inject.Inject
import javax.inject.Provider

interface NetworkDependencies : BaseDependencies

@AppScope
class NetworkFeature @Inject constructor(
    dependencies: Provider<NetworkDependencies>
) : BaseFeature<NetworkFeatureApi, NetworkDependencies>(dependencies) {
    private val _api: NetworkFeatureApi by lazy {
        DaggerNetworkComponent.builder()
            .networkDependencies(dependencies.get())
            .build()
            .also { networkComponent = it }
    }

    override fun getApi(): NetworkFeatureApi = _api

    companion object {
        internal var networkComponent: NetworkComponent? = null
    }
}