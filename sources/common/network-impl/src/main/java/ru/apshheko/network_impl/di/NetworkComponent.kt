package ru.apshheko.network_impl.di

import dagger.Component
import ru.apshheko.baseapp.di.PerFeature
import ru.apshheko.network_api.di.NetworkFeatureApi

@PerFeature
@Component(modules = [NetworkModule::class], dependencies = [NetworkDependencies::class])
interface NetworkComponent : NetworkFeatureApi