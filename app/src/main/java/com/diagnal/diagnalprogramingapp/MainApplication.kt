package com.diagnal.diagnalprogramingapp

import android.app.Application
import com.diagnal.diagnalprogramingapp.moduls.appModule
import org.koin.android.ext.android.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }

}
