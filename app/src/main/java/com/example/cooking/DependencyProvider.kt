package com.example.cooking

import com.example.cooking.data.remote.MockRecipeCardDataSource
//import com.example.cooking.data.remote.MockRecipeDataSource
import com.example.cooking.data.remote.RecipeDataSource

object DependencyProvider {
    val recipeDataSource: RecipeDataSource = MockRecipeCardDataSource()
}

/* NOTE ON DEPENDENCY PROVIDER
A dependency provider is used in order for our code to follow the Dependency Injection
principle. This allows the ViewModel to get the data it needs through the Dependency Provider instead
of fetching it directly. This allows for lower coupling and increased code re-usability as it
can be used to provide different dependencies throughout the app
 */