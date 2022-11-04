package com.example.onboardinginternapp.di

import android.app.Application
import com.example.onboardinginternapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(
                listOf(
                    viewModelModule,
                    localDbModule,
                    AppModule,
                    repoModule
                )
            )
        }
    }
}