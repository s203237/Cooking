package com.example.cooking.data.remote
import retrofit2.http.GET
interface ApiService {
    @GET("cats?tags=orange&limit=20")
    suspend fun fetchAllCats(): List<RecipeDto>
}