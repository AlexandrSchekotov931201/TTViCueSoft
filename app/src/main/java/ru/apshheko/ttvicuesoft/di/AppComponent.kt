package ru.apshheko.ttvicuesoft.di

import dagger.Component
import ru.apshheko.baseapp.di.AppScope
import ru.apshheko.baseapp.di.BaseFeatureApi

@AppScope
@Component(modules = [AppModule::class, BaseFeatureModule::class])
interface AppComponent {
    fun getFirstInitFeatures(): List<BaseFeatureApi>
}