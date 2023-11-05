package com.example.cooking.data.remote
import com.example.cooking.model.Recipe
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("collection/breakfast-recipes/recipes/?rapidapi-key=564d89b1demshec6f0e210cbdd20p1c252ajsnafddd033c068")
    suspend fun fetchRecipeCollection(): RecipeCollection

    @GET("recipe/{recipeId}/?rapidapi-key=564d89b1demshec6f0e210cbdd20p1c252ajsnafddd033c068")
    suspend fun fetchRecipeById(@Path("recipeId") recipeID: String): Recipe
}