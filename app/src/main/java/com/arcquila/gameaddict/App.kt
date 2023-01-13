package com.arcquila.gameaddict

import android.app.Application
import com.arcquila.gameaddict.di.homeModule
import com.arcquila.gameaddict.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(homeModule, networkModule)
        }
    }
}