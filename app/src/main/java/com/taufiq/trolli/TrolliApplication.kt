package com.taufiq.trolli

import android.app.Application
import com.taufiq.profile.di.ProfileModuleContainer
import com.taufiq.homepage.di.HomePageModuleContainer
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class TrolliApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        val homePageModuleContainer = com.taufiq.homepage.di.HomePageModuleContainer()
        val profileModuleContainer = ProfileModuleContainer()

        startKoin {
            androidContext(this@TrolliApplication)
            modules(homePageModuleContainer.modules() + profileModuleContainer.modules())
        }
    }


}