package com.example.cooking

import com.example.cooking.data.remote.MockRecipeDataSource
import com.example.cooking.data.remote.RecipeCard
import com.example.cooking.data.remote.RecipeDataSource
import com.example.cooking.data.remote.RemoteRecipeCardsDataSource
import com.example.cooking.data.remote.RemoteRecipeDataSource
import com.example.cooking.model.Recipe

object DependencyProvider {
    val recipeDataSource: RecipeDataSource<Recipe> = RemoteRecipeDataSource()
   // val recipeDataSource: RecipeDataSource<List<String>> = MockRecipeDataSource()
   // val recipeCardDataSource: RecipeDataSource<List<String>> = MockRecipeCardDataSource()
    val recipeCardDataSource: RecipeDataSource<List<RecipeCard>> = RemoteRecipeCardsDataSource()
}

/* NOTE ON DEPENDENCY PROVIDER
A dependency provider is used in order for our code to follow the Dependency Injection
principle. This allows the ViewModel to get the data it needs through the Dependency Provider instead
of fetching it directly. This allows for lower coupling and increased code re-usability as it
can be used to provide different dependencies throughout the app
 */