package com.example.cooking.data.remote
import retrofit2.http.GET
interface ApiService {
    @GET("collection/breakfast-recipes/recipes/?rapidapi-key=564d89b1demshec6f0e210cbdd20p1c252ajsnafddd033c068")
    suspend fun fetchRecipeCollection(): RecipeCollection
}