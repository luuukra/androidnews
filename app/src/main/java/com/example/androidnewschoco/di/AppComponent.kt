package com.example.androidnewschoco.di

import android.app.Application
import com.example.androidnewschoco.ui.NewsActivity
import com.example.androidnewschoco.ui.fragments.NewsFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModules::class)])
interface AppComponent {

    fun injectActivity(newsActivity: NewsActivity)
    fun injectFragment(newsFragment: NewsFragment)

}