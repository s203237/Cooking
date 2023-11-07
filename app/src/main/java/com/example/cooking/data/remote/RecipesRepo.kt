package com.example.cooking.data.remote

import com.example.cooking.model.Recipe
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.HttpException
import retrofit2.Retrofit
import java.io.IOException

class RecipesRepo(apiService: ApiService) : RecipeDataSource<Recipe> {
    private val apiService = apiService
    override suspend fun fetchData(path: String): Recipe {
        try {
            return apiService.fetchRecipeById(path)
        } catch (e: IOException) {
            println("It broke :((( ${e.message}")
        } catch (e: HttpException) {
            val errorCode = e.code()
            val errorResponse = e.response()?.errorBody()?.string()
            println("HTTP error occurred - Code: $errorCode, Response: $errorResponse")
        }
        return Recipe()
    }
}