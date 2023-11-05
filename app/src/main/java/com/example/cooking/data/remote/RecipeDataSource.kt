package com.example.cooking.data.remote

interface RecipeDataSource<T> {
    suspend fun fetchData(path: String): T
}