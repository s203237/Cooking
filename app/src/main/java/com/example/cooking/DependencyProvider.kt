package com.example.cooking

import com.example.cooking.data.remote.ApiService

import com.example.cooking.data.remote.AuthenticationInterceptor
//import com.example.cooking.data.remote.MockApiService
import com.example.cooking.data.remote.RecipeCardRepo
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
    .baseUrl("https://tasty.p.rapidapi.com/") // Base url for the api has to end with a slash.
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
        .baseUrl("https://tasty.p.rapidapi.com/")
        .build()

    private val apiService = retrofit.create(ApiService::class.java)


    //private val mockapiService = MockApiService()

    val recipeRepo: RecipeDataRepo<Recipe> = RecipesRepo(apiService)
    val recipeCardRepo: RecipeDataRepo<List<RecipeCard>> = RecipeCardsRepo(apiService2)

    val recipeCardsRepoSearch: RecipeDataRepo<List<RecipeCard>> = RecipeCardsRepoSearch(apiService2)

    val recipeSingleCardRepo: RecipeDataRepo<RecipeCard> = RecipeCardRepo(apiService)




    val apiKeyInterceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("X-RapidAPI-Key", "173f6e51b0msh4dadab55e6361b6p13a3ebjsndf11d2202516")
            .build()
        chain.proceed(request)
    }

    val newclient = OkHttpClient.Builder()
        .addInterceptor(apiKeyInterceptor)
        .build()

    val newapi2 = Retrofit.Builder() // Create retrofit builder.
        .baseUrl("https://tasty.p.rapidapi.com/") // Base url for the api has to end with a slash.
        .addConverterFactory(GsonConverterFactory.create()) // Use GSON converter for JSON to POJO object mapping.
        .client(newclient) // Here we set the custom OkHttp client we just created.
        .build()
    private val newapiService2 = newapi2.create(ApiService::class.java)


    private val retrofit2 = Retrofit.Builder()
        .addConverterFactory(
            Json {
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType())
        )
        .baseUrl("https://tasty.p.rapidapi.com/")
        .client(newclient)
        .build()

    private val newapiService = retrofit2.create(ApiService::class.java)

    val newrecipeCardRepo: RecipeDataRepo<List<RecipeCard>> = RecipeCardsRepo(newapiService)
}

/* NOTE ON DEPENDENCY PROVIDER
A dependency provider is used in order for our code to follow the Dependency Injection
principle. This allows the ViewModel to get the data it needs through the Dependency Provider instead
of fetching it directly. This allows for lower coupling and increased code re-usability as it
can be used to provide different dependencies throughout the app
 */