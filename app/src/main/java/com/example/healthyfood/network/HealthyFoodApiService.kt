package com.example.healthyfood.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.edamam.com"
private const val app_id = "7159b80c"
private const val app_key = "4ae03d785087c5a731449601355a5970"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface HealthyFoodApiService {
    @GET("/api/recipes/v2?type=public")
    //@GET("/api/recipes/v2?type=public&q=chicken&app_id=7159b80c&app_key=4ae03d785087c5a731449601355a5970")
    suspend fun getRecipes(
        @Query("app_id") id: String = app_id,
        @Query("app_key") key: String = app_key,
        @Query("q") q: String = "chicken"
    ): String
}

object HealthyFoodApi {
    val retrofitService : HealthyFoodApiService by lazy {
        retrofit.create(HealthyFoodApiService::class.java)
    }
}