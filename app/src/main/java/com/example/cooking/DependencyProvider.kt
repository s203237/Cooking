package com.example.cooking

import FavoritesDataSource
import android.content.Context
import com.example.cooking.data.local.DataStoreFavoritesDataSource
import com.example.cooking.data.remote.ApiService
import com.example.cooking.data.remote.RecipeCardRepo
import com.example.cooking.data.remote.RecipeDataRepo
import com.example.cooking.data.remote.RecipeCardsRepo
import com.example.cooking.data.remote.RecipesRepo
import com.example.cooking.model.Recipe
import com.example.cooking.model.RecipeCard
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 *  Uses Retrofit to create an instance of the `ApiService` for network operations.
 *  - Configures the base URL for the remote API and sets up JSON parsing using Kotlinx Serialization.
 *  - Provides instances of `RecipeDataRepo` for fetching both detailed recipes and recipe cards.
 */
object DependencyProvider {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json {
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType())
        )
        .baseUrl("https://bbc-good-food-api.p.rapidapi.com/")
        .client(OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).build()) // Set a timeout (e.g., 30 seconds)
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    val recipeRepo: RecipeDataRepo<Recipe> = RecipesRepo(apiService)
    val recipeCardRepo: RecipeDataRepo<List<RecipeCard>> = RecipeCardsRepo(apiService)
    val recipeSingleCardRepo: RecipeDataRepo<RecipeCard> = RecipeCardRepo(apiService)

    lateinit var favoritesDataSource: FavoritesDataSource
        private set
    fun initialize(context : Context){
        favoritesDataSource = DataStoreFavoritesDataSource(context)
    }
}

/* NOTE ON DEPENDENCY PROVIDER
A dependency provider is used in order for our code to follow the Dependency Injection
principle. This allows the ViewModel to get the data it needs through the Dependency Provider instead
of fetching it directly. This allows for lower coupling and increased code re-usability as it
can be used to provide different dependencies throughout the app
 */