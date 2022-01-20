package com.example.androidnewschoco.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidnewschoco.data.repository.NewsRepository
import com.example.androidnewschoco.models.NewsResponse
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsRepository: NewsRepository
) : ViewModel() {

    val news: MutableLiveData<NewsResponse> = MutableLiveData()
    var newsPage = 1
    var newsResponse: NewsResponse? = null

    init {
        getNews("android")
    }

    private fun getNews(topicKey: String) = viewModelScope.launch {
        val response = newsRepository.getNews(topicKey, newsPage)
        news.postValue(response.body())

    }
}












