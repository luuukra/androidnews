package com.example.androidnewschoco.data.api

import com.example.androidnewschoco.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {
    @GET("v2/everything")
    suspend fun getNews(): Response<NewsResponse>
}