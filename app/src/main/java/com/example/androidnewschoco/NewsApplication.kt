package com.example.androidnewschoco

import android.app.Application
import com.example.androidnewschoco.di.AppComponent
import com.example.androidnewschoco.di.AppModules
import com.example.androidnewschoco.di.DaggerAppComponent

class NewsApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModules(AppModules(context = this))
            .build()

    }
}