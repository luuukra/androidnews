package com.example.androidnewschoco.di

import android.app.Application
import android.content.Context
import com.example.androidnewschoco.data.repository.NewsRepository
import com.example.androidnewschoco.viewmodels.NewsViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class AppModules(private val context: Context) {

    @Provides
    fun provideApp(): Application {
        return Application()
    }

    @Provides
    fun provideContext() : Context {
        return context
    }

    @Provides
    fun provideNewsRepository(): NewsRepository {
        return NewsRepository()
    }

    @Provides
    fun provideNewsViewModelFactory(
        newsRepository: NewsRepository
    ) : NewsViewModelProviderFactory {
        return NewsViewModelProviderFactory(
            newsRepository = newsRepository
        )
    }
}