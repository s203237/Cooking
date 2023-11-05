package com.example.cooking.data.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import java.io.IOException

class RemoteRecipeCardsDataSource : RecipeDataSource<List<RecipeCard>> {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json {
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType())
        )
        .baseUrl("https://bbc-good-food-api.p.rapidapi.com/")
        .build()

    private val apiService = retrofit.create(ApiService::class.java)
    override suspend fun fetchData(collectionName: String): List<RecipeCard> {
        println("Printing just before collection name ")
        try {
            val recipeCollection = apiService.fetchRecipeCollection()
            println("Printing collection name: " + recipeCollection.collectionName)
            return recipeCollection.results
        } catch (e : IOException) {
            println("It broke :((( ${e.message}")
        } catch (e: HttpException) {
            val errorCode = e.code()
            val errorResponse = e.response()?.errorBody()?.string()
            println("HTTP error occurred - Code: $errorCode, Response: $errorResponse")
        }
        return emptyList()
    }
}