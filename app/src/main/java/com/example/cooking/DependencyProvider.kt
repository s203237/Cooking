package com.example.cooking

import com.example.cooking.data.remote.ApiService
import com.example.cooking.data.remote.RecipeDataRepo
import com.example.cooking.data.remote.RecipeCardsRepo
import com.example.cooking.data.remote.RecipesRepo
import com.example.cooking.model.Recipe
import com.example.cooking.model.RecipeCard
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object DependencyProvider {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json {
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType())
        )
        .baseUrl("https://bbc-good-food-api.p.rapidapi.com/")
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    val recipeRepo: RecipeDataRepo<Recipe> = RecipesRepo(apiService)
   // val recipeDataSource: RecipeDataSource<List<String>> = MockRecipeDataSource()
   // val recipeCardDataSource: RecipeDataSource<List<String>> = MockRecipeCardDataSource()
    val recipeCardRepo: RecipeDataRepo<List<RecipeCard>> = RecipeCardsRepo(apiService)
}

/* NOTE ON DEPENDENCY PROVIDER
A dependency provider is used in order for our code to follow the Dependency Injection
principle. This allows the ViewModel to get the data it needs through the Dependency Provider instead
of fetching it directly. This allows for lower coupling and increased code re-usability as it
can be used to provide different dependencies throughout the app
 */