package com.example.cooking.data.remote

import com.example.cooking.model.RecipeCollection
import retrofit2.HttpException
import java.io.IOException

/**
 * This class, `RecipeCollection`, is an implementation of the `RecipeDataRepo` interface
 * specialized for fetching a collection of recipe cards. The class implements the `RecipeDataRepo<T>` interface, defining the
 * behavior for fetching a [RecipeCollection] object from a remote data source.
 *
 * @param apiService An instance of [ApiService] used for making network requests.
 *
 *
 * Functions:
 * - `fetchData(collectionName: String)`: Retrieves a collection associated with the
 * specified collection name from the remote API.
 *
 * Parameters:
 *
 *   - `collectionName`: The name of the collection to fetch recipe cards from.
 *
 * Returns:
 *
 *   - A [RecipeCollection] object if the data retrieval is successful.
 *   - A default RecipeCollection object if an error occurs during the retrieval process.
 */
class RecipeCollectionRepo(apiService: ApiService) : RecipeDataRepo<RecipeCollection> {
    private val apiService = apiService
    override suspend fun fetchData(collectionName: String): RecipeCollection {

        try {
            return apiService.fetchRecipeCollection(searchTerm = collectionName)
        } catch (e: IOException) {
            println("It broke :((( ${e.message}")
        } catch (e: HttpException) {
            val errorCode = e.code()
            val errorResponse = e.response()?.errorBody()?.string()
            println("HTTP error occurred - Code: $errorCode, Response: $errorResponse")
        }
        return RecipeCollection()
    }
}