package com.example.androidnewschoco.data.repository

import com.example.androidnewschoco.data.api.RetrofitInstance

class NewsRepository() {

    suspend fun getNews(topicKey: String, page: Int) =
        RetrofitInstance.api.getNews(topicKey, page)

}