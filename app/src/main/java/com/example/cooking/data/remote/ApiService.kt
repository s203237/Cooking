package com.example.cooking.data.remote
import com.example.cooking.model.Recipe
import com.example.cooking.model.RecipeCollection
import retrofit2.http.GET
import retrofit2.http.Path

/**
* The `ApiService` interface defines methods for making network requests to a cooking-related API.
*
* Functions:
* - `fetchRecipeCollection(collectionName: String)`: Retrieves a collection of recipes based on the
*   specified collection name.
*   - Parameters:
*     - `collectionName`: The name of the recipe collection to fetch.
*   - Returns:
*     - A [RecipeCollection] object representing the fetched collection of recipes.
*
* - `fetchRecipeById(recipeId: String)`: Retrieves a specific recipe by its unique identifier.
*   - Parameters:
*     - `recipeId`: The unique identifier of the recipe to fetch.
*   - Returns:
*     - A [Recipe] object representing the fetched recipe.
*/
interface ApiService {
    @GET("collection/{collectionName}/recipes/?rapidapi-key=564d89b1demshec6f0e210cbdd20p1c252ajsnafddd033c068")
    suspend fun fetchRecipeCollection(@Path("collectionName") collectionName: String): RecipeCollection

    @GET("recipe/{recipeId}/?rapidapi-key=564d89b1demshec6f0e210cbdd20p1c252ajsnafddd033c068")
    suspend fun fetchRecipeById(@Path("recipeId") recipeId: String): Recipe
}