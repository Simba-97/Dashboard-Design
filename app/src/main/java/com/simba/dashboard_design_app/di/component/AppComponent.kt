package com.simba.dashboard_design_app.di.component

import com.simba.dashboard_design_app.DashboardDesignApp
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@EntryPoint
interface AppComponent {
    fun inject(app: DashboardDesignApp?)
}