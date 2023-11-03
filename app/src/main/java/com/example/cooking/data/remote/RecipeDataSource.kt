package com.example.cooking.data.remote

interface RecipeDataSource {
    suspend fun fetchRecipes(): List<String>
}