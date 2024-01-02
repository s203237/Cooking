package com.example.cooking.data.remote

interface RecipeDataRepoNew<T> {
    suspend fun fetchData(path: String): T
}