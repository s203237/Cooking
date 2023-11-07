package com.example.cooking.data.remote

import com.example.cooking.model.RecipeCard
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import java.io.IOException

class RemoteRecipeCardsRepo(apiService: ApiService) : RecipeDataSource<List<RecipeCard>> {
    private val apiService = apiService
    override suspend fun fetchData(collectionName: String): List<RecipeCard> {

        try {
            val recipeCollection = apiService.fetchRecipeCollection(collectionName)
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