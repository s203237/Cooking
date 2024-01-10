package com.example.cooking.data.remote
import com.example.cooking.model.Recipe
import com.example.cooking.model.RecipeCard
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
* The `ApiService` interface defines methods for making network requests to a BBCGoodFood API.
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

    @GET("recipes/list")
    suspend fun fetchRecipeCollection(
        @Query("q") searchTerm: String,
        @Query("size") size: Int = 30,
        @Query("tags") tag: String = "vegetarian"
    ): CollectionDto

    @GET("recipes/get-more-info")
    suspend fun fetchRecipeById(
        @Query("id") recipeId: String
    ): Recipe


    @GET("recipe/{recipeId}/?rapidapi-key=153fb15982msh07ef790555391adp1e7d60jsna0d4c47abb3c")
    suspend fun fetchRecipeCardById(@Path("recipeId") recipeId: String): RecipeCard


}

