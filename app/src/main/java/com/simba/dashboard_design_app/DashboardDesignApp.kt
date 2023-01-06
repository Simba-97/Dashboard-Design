package com.simba.dashboard_design_app

import android.app.Application
import com.simba.dashboard_design_app.di.component.AppComponent
import dagger.hilt.EntryPoints
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DashboardDesignApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        component().inject(this)
    }

    fun component(): AppComponent {
        return EntryPoints.get(this, AppComponent::class.java)
    }

    companion object {
        @get:Synchronized
        lateinit var instance: DashboardDesignApp
    }
}