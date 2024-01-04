package com.example.cooking.data.remote

import com.example.cooking.model.Recipe
import com.example.cooking.model.RecipeCard
import retrofit2.HttpException
import java.io.IOException

/**
 * This class, `RecipesRepo`, is an implementation of the `RecipeDataRepo` interface
 * specialized for fetching a recipe. The class implements the `RecipeDataRepo<T>` interface, defining the
 * behavior for fetching a [Recipe] object from a remote data source.
 *
 * @param apiService An instance of [ApiService] used for making network requests.
 *
 *
 * Functions:
 * - `fetchData(recipeId: String)`: Retrieves the recipe associated with the
 * specified recipeId from the remote API.
 *
 * Parameters:
 *
 *   - `recipeId`: The ID of the recipe to be fetched.
 *
 * Returns:
 *
 *   - An instance of Recipe
 */
class RecipesRepo(apiService: ApiService) : RecipeDataRepo<Recipe> {
    private val apiService = apiService
    override suspend fun fetchData(path: String?, tags: String?): Recipe {
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