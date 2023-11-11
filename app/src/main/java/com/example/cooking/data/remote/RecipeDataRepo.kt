package com.example.cooking.data.remote

interface RecipeDataRepo<T> {
    suspend fun fetchData(path: String): T
}