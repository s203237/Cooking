package com.example.cooking.data.remote

import com.example.cooking.model.RecipeCard
import retrofit2.HttpException
import java.io.IOException

class RecipeCardRepo (apiService: ApiService) : RecipeDataRepo<RecipeCard> {
    private val apiService = apiService
    override suspend fun fetchData(path: String): RecipeCard {
        try {
            return apiService.fetchRecipeCardById(path)
        } catch (e: IOException) {
            println("It broke :((( ${e.message}")
        } catch (e: HttpException) {
            val errorCode = e.code()
            val errorResponse = e.response()?.errorBody()?.string()
            println("HTTP error occurred - Code: $errorCode, Response: $errorResponse")
        }
        return RecipeCard()
    }
}
/*class RecipeCardRepo(private val apiService: ApiService) : RecipeDataRepo<RecipeCard> {
    override suspend fun fetchData(path: String): RecipeCard {
        return try {
            // This call may return null
            val response = apiService.fetchRecipeCardById(path)
            // If response is null, return a default RecipeCard or handle accordingly
            response ?: RecipeCard() // Assuming RecipeCard has a default constructor
        } catch (e: IOException) {
            println("It broke :((( ${e.message}")
            RecipeCard() // Return default RecipeCard in case of IOException
        } catch (e: HttpException) {
            val errorCode = e.code()
            val errorResponse = e.response()?.errorBody()?.string()
            println("HTTP error occurred - Code: $errorCode, Response: $errorResponse")
            RecipeCard() // Return default RecipeCard in case of HttpException
        }
    }
}
*/