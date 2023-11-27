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
    @GET("collection/{collectionName}/recipes/?rapidapi-key=f126ee70a3msh878012a5b25f30ap13b19fjsn993601390640")
    suspend fun fetchRecipeCollection(@Path("collectionName") collectionName: String): RecipeCollection

    @GET("recipe/{recipeId}/?rapidapi-key=f126ee70a3msh878012a5b25f30ap13b19fjsn993601390640")
    suspend fun fetchRecipeById(@Path("recipeId") recipeId: String): Recipe


    @GET("search?rapidapi-key=f126ee70a3msh878012a5b25f30ap13b19fjsn993601390640")
    suspend fun fetchRecipeList(@Query("query") query: String): RecipeCollection

    @GET("recipe/{recipeId}/?rapidapi-key=f126ee70a3msh878012a5b25f30ap13b19fjsn993601390640")
    suspend fun fetchRecipeCardById(@Path("recipeId") recipeId: String): RecipeCard
}

