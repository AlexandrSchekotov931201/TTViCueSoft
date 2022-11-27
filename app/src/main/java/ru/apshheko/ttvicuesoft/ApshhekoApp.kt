package ru.apshheko.ttvicuesoft

import android.app.Application
import ru.apshheko.ttvicuesoft.di.AppComponent
import ru.apshheko.ttvicuesoft.di.AppModule
import ru.apshheko.ttvicuesoft.di.DaggerAppComponent

class ApshhekoApp : Application() {
    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        appComponent?.getFirstInitFeatures()
    }
}