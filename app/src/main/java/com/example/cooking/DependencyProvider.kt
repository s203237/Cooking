package com.example.cooking

import androidx.compose.runtime.Composable
import com.example.cooking.data.remote.ApiService

import com.example.cooking.data.remote.AuthenticationInterceptor
import com.example.cooking.data.remote.MockApiService
import com.example.cooking.data.remote.RecipeCardRepo
import com.example.cooking.data.remote.RecipeDataRepo
import com.example.cooking.data.remote.RecipeCardsRepo
import com.example.cooking.data.remote.RecipeCardsRepoSearch
import com.example.cooking.data.remote.RecipesRepo
import com.example.cooking.model.Recipe
import com.example.cooking.model.RecipeCard
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *  Uses Retrofit to create an instance of the `ApiService` for network operations.
 *  - Configures the base URL for the remote API and sets up JSON parsing using Kotlinx Serialization.
 *  - Provides instances of `RecipeDataRepo` for fetching both detailed recipes and recipe cards.
 */
object DependencyProvider {

    fun createBuilder(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60,TimeUnit.SECONDS)
        builder.interceptors().add(AuthenticationInterceptor())
        val client = builder.build()
        return client
    }
    val client = createBuilder()
    val api2 = Retrofit.Builder() // Create retrofit builder.
    .baseUrl("https://bbc-good-food-api.p.rapidapi.com/") // Base url for the api has to end with a slash.
    .addConverterFactory(GsonConverterFactory.create()) // Use GSON converter for JSON to POJO object mapping.
    .client(client) // Here we set the custom OkHttp client we just created.
    .build()

    private val apiService2 = api2.create(ApiService::class.java)

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json {
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType())
        )
        .baseUrl("https://bbc-good-food-api.p.rapidapi.com/")
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    val mockapi = Retrofit.Builder() // Create retrofit builder.
        .baseUrl("https://65636d57ee04015769a730e1.mockapi.io/") // Base url for the api has to end with a slash.
        .addConverterFactory(GsonConverterFactory.create()) // Use GSON converter for JSON to POJO object mapping.
        .client(client) // Here we set the custom OkHttp client we just created.
        .build()

    private val mockapiService = mockapi.create(ApiService::class.java)

    val recipeRepo: RecipeDataRepo<Recipe> = RecipesRepo(apiService)
    val recipeCardRepo: RecipeDataRepo<List<RecipeCard>> = RecipeCardsRepo(mockapiService)


    val recipeCardsRepoSearch: RecipeDataRepo<List<RecipeCard>> = RecipeCardsRepoSearch(apiService2)

    val recipeSingleCardRepo: RecipeDataRepo<RecipeCard> = RecipeCardRepo(apiService)


}

/* NOTE ON DEPENDENCY PROVIDER
A dependency provider is used in order for our code to follow the Dependency Injection
principle. This allows the ViewModel to get the data it needs through the Dependency Provider instead
of fetching it directly. This allows for lower coupling and increased code re-usability as it
can be used to provide different dependencies throughout the app
 */