package com.example.cooking

import com.example.cooking.data.remote.ApiService
import com.example.cooking.data.remote.RecipeDataRepo
import com.example.cooking.data.remote.RecipeCardsRepo
import com.example.cooking.data.remote.RecipeCardsRepoSearch
import com.example.cooking.data.remote.RecipesRepo
import com.example.cooking.model.Recipe
import com.example.cooking.model.RecipeCard
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 *  Uses Retrofit to create an instance of the `ApiService` for network operations.
 *  - Configures the base URL for the remote API and sets up JSON parsing using Kotlinx Serialization.
 *  - Provides instances of `RecipeDataRepo` for fetching both detailed recipes and recipe cards.
 */
object DependencyProvider {

    val apiKeyInterceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("X-RapidAPI-Key", "173f6e51b0msh4dadab55e6361b6p13a3ebjsndf11d2202516")
            .build()
        chain.proceed(request)
    }

    val client = OkHttpClient.Builder()
        .addInterceptor(apiKeyInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json {
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType())
        )
        .baseUrl("https://tasty.p.rapidapi.com/")
        .client(client)
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    val recipeCardRepo: RecipeDataRepo<List<RecipeCard>> = RecipeCardsRepo(apiService)
    val recipeRepo: RecipeDataRepo<Recipe> = RecipesRepo(apiService)
    val recipeCardsRepoSearch: RecipeDataRepo<List<RecipeCard>> = RecipeCardsRepoSearch(apiService)
}

/* NOTE ON DEPENDENCY PROVIDER
A dependency provider is used in order for our code to follow the Dependency Injection
principle. This allows the ViewModel to get the data it needs through the Dependency Provider instead
of fetching it directly. This allows for lower coupling and increased code re-usability as it
can be used to provide different dependencies throughout the app
 */