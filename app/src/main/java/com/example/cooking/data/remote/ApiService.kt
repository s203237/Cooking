package com.example.cooking.data.remote
import com.example.cooking.model.Recipe
import com.example.cooking.model.RecipeCard
import com.example.cooking.model.RecipeCollection
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
        @Query("size") size: Int = 10,
        @Query("tags") tag: String = "vegetarian"
    ): RecipeCollection

    @GET("recipes/get-more-info")
    suspend fun fetchRecipeById(
        @Query("id") recipeId: String
    ): Recipe


    @GET("recipe/{recipeId}/?rapidapi-key=65ff42b648msha1e6f88928a2e65p12d37fjsn3963912f1b92")
    suspend fun fetchRecipeCardById(@Path("recipeId") recipeId: String): RecipeCard
}

