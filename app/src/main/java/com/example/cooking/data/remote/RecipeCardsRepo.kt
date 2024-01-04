package com.example.cooking.data.remote

import com.example.cooking.model.RecipeCard
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

/**
 * This class, `RecipeCardsRepo`, is an implementation of the `RecipeDataRepo` interface
 * specialized for fetching a collection of recipe cards. The class implements the `RecipeDataRepo<T>` interface, defining the
 * behavior for fetching a list of [RecipeCard] objects from a remote data source.
 *
 * @param apiService An instance of [ApiService] used for making network requests.
 *
 *
 * Functions:
 * - `fetchData(collectionName: String)`: Retrieves a list of recipe cards associated with the
 * specified collection name from the remote API.
 *
 * Parameters:
 *
 *   - `collectionName`: The name of the collection to fetch recipe cards from.
 *
 * Returns:
 *
 *   - A list of [RecipeCard] objects if the data retrieval is successful.
 *   - An empty list if an error occurs during the retrieval process.
 *
 *   Similar explanation for class 'RecipeCardsRepoSearch' and functions 'fetchData(query: String)'
 */
class RecipeCardsRepo(private val apiService: ApiService) : RecipeDataRepo<List<RecipeCard>> {
    override suspend fun fetchData(q: String?, tags: String?): List<RecipeCard> {

        try {
            val recipeCollection = apiService.fetchRecipeCollection(searchTerm = q, tag = tags)
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
