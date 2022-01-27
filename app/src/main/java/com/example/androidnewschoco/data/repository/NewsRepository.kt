package com.example.androidnewschoco.data.repository

import com.example.androidnewschoco.data.api.RetrofitInstance

class NewsRepository() {

    suspend fun getNews() =
        RetrofitInstance.api.getNews()
}