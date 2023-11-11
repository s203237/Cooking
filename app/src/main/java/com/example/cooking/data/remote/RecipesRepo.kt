package com.example.cooking.data.remote

import com.example.cooking.model.Recipe
import retrofit2.HttpException
import java.io.IOException

class RecipesRepo(apiService: ApiService) : RecipeDataRepo<Recipe> {
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