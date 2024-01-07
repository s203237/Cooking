package com.example.cooking.data.remote

/*class RecipeCardRepo (apiService: ApiService) : RecipeDataRepo<RecipeCard> {
    private val apiService = apiService
    override suspend fun fetchData(path: String): RecipeCard {
        try {
            return apiService.fetchRecipeCardById(path)
        } catch (e: IOException) {
            println("It broke :((( ${e.message}")
        } catch (e: HttpException) {
            val errorCode = e.code()
            val errorResponse = e.response()?.errorBody()?.string()
            println("HTTP error occurred - Code: $errorCode, Response: $errorResponse")
        }
        return RecipeCard()
    }
}*/