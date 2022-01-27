package com.example.androidnewschoco.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidnewschoco.data.repository.NewsRepository
import com.example.androidnewschoco.models.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsRepository: NewsRepository
) : ViewModel() {

    val news: MutableLiveData<NewsResponse> = MutableLiveData()

    init {
        getNews()
    }

    private fun getNews() = viewModelScope.launch(Dispatchers.IO) {
        val response = newsRepository.getNews()
        news.postValue(response.body())
    }
}












