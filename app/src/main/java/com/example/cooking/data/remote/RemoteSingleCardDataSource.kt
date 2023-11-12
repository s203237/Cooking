package com.example.cooking.data.remote

import androidx.compose.runtime.Composable
import com.example.cooking.model.Recipe
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.HttpException
import retrofit2.Retrofit
import java.io.IOException
import com.example.cooking.model.RecipeCard

class RemoteSingleCardDataSource : RecipeDataSource<RecipeCard> {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json {
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType())
        )
        .baseUrl("https://bbc-good-food-api.p.rapidapi.com/")
        .build()

    private val apiService = retrofit.create(ApiService::class.java)
    override suspend fun fetchData(path: String): RecipeCard {
        try {
            val recipeSingleCard = apiService.fetchRecipeCardById(path)
            return recipeSingleCard

        } catch (e : IOException) {
            println("It broke :((( ${e.message}")
        } catch (e: HttpException) {
            val errorCode = e.code()
            val errorResponse = e.response()?.errorBody()?.string()
            println("HTTP error occurred - Code: $errorCode, Response: $errorResponse")
        }
        return RecipeCard()
    }

}