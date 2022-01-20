package com.example.androidnewschoco.di

import com.example.androidnewschoco.ui.NewsActivity
import dagger.Component

@Component(modules = [AppModules::class])
interface AppComponent {

    fun inject(newsActivity: NewsActivity)

}