package com.example.cooking.data.remote

interface RecipeDataSource {
    suspend fun fetchData(): List<String>
}