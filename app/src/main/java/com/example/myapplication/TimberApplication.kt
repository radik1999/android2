package com.example.myapplication

import android.app.Application
import timber.log.Timber


class PusherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

    }
}