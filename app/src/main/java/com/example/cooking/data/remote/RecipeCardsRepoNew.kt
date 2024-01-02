package com.example.cooking.data.remote

import com.example.cooking.model.RecipeCard
import retrofit2.HttpException
import java.io.IOException

class RecipeCardsRepoNew(apiService: ApiService) : RecipeDataRepoNew<List<RecipeCard>> {
    private val apiService = apiService
    override suspend fun fetchData(collectionName: String): List<RecipeCard> {

        try {
            val recipeCollection = apiService.fetchRecipeNewAPI(collectionName)
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