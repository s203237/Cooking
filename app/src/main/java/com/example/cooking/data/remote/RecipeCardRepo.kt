package com.example.cooking.data.remote

import com.example.cooking.model.RecipeCard
import retrofit2.HttpException
import java.io.IOException

class RecipeCardRepo (apiService: ApiService) : RecipeDataRepo<RecipeCard> {
    private val apiService = apiService
    override suspend fun fetchData(path: String): RecipeCard {
        /*try {
            return apiService.fetchRecipeCardById(path)
        } catch (e: IOException) {
            println("It broke :((( ${e.message}")
        } catch (e: HttpException) {
            val errorCode = e.code()
            val errorResponse = e.response()?.errorBody()?.string()
            println("HTTP error occurred - Code: $errorCode, Response: $errorResponse")
        }*/
        try {
            println("Fetching data for path: $path")
            val recipeCard = apiService.fetchRecipeCardById(path)
            println("Fetched RecipeCard: $recipeCard")
            return recipeCard
        } catch (e: IOException) {
            println("IOException occurred: ${e.message}")
        } catch (e: HttpException) {
            println("HttpException occurred - Code: ${e.code()}, Response: ${e.response()?.errorBody()?.string()}")
        }
        return RecipeCard(isFavorite = false)
    }
}