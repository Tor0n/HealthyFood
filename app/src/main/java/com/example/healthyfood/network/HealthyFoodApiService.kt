package com.example.healthyfood.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.edamam.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface HealthyFoodApiService {
    @GET("/api/recipes/v2")
    suspend fun getPhotos(): String
}

object HealthyFoodApi {
    val retrofitService : HealthyFoodApiService by lazy {
        retrofit.create(HealthyFoodApiService::class.java)
    }
}