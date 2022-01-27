package com.example.androidnewschoco.di

import android.content.Context
import com.example.androidnewschoco.data.repository.NewsRepository
import com.example.androidnewschoco.viewmodels.NewsViewModelProviderFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModules(private val context: Context) {

    @Provides
    fun provideContext() : Context {
        return context
    }

    @Singleton
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