package com.example.cooking.data.remote

import com.example.cooking.model.Recipe
import com.example.cooking.model.RecipeCard
import com.example.cooking.model.RecipeCollection
import com.example.cooking.model.TimeToCook

class MockApiService: ApiService {
    override suspend fun fetchRecipeCollection(collectionName: String): RecipeCollection {
        // Simulate a successful response with dummy data
        return RecipeCollection(
            results = listOf(
                RecipeCard(
                    recipeId = "mockId1",
                    title = "Mock Recipe 1",
                    isFavorite = false,
                    imageUrl = "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/spiced-lentil-spinach-pies-a1ae301.jpg"
                ),
                RecipeCard(
                    recipeId = "mockId2",
                    title = "Mock Recipe 2",
                    isFavorite = false,
                    imageUrl = "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/spiced-lentil-spinach-pies-a1ae301.jpg"
                ),
                RecipeCard(
                    recipeId = "mockId3",
                    title = "Mock Recipe 3",
                    isFavorite = false,
                    imageUrl = "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/spiced-lentil-spinach-pies-a1ae301.jpg"
                ),
                RecipeCard(
                    recipeId = "mockId4",
                    title = "Mock Recipe 4",
                    isFavorite = false,
                    imageUrl = "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/spiced-lentil-spinach-pies-a1ae301.jpg"
                ),
                RecipeCard(
                    recipeId = "mockId5",
                    title = "Mock Recipe 5",
                    isFavorite = false,
                    imageUrl = "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/spiced-lentil-spinach-pies-a1ae301.jpg"
                ),
                // Add more mock recipes as needed
            )
        )
    }

    override suspend fun fetchRecipeById(recipeId: String): Recipe {
        return Recipe(
            recipeId = "mockId",
            title = "Mock Recipe",
            imageUrl = "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/spiced-lentil-spinach-pies-a1ae301.jpg",
            imageDescription = "Mock image description",
            author = "Mock Author",
            timeToCook = TimeToCook(prepTime = "10 minutes", cookTime = "20 minutes"),
            difficulty = "Easy",
            servingSize = "4",
            rating = 4.5f,
            recipeDescription = "Mock recipe description",
            ingredients = listOf("Ingredient 1", "Ingredient 2"),
            steps = mapOf("Step 1" to "Do something", "Step 2" to "Do something else"),
            isFavorite = false
        )
    }

    suspend fun fetchRecipeList(temp: String): RecipeCollection {
        TODO("Not yet implemented")
    }

    override suspend fun fetchRecipeCardById(recipeId: String): RecipeCard {
        TODO("Not yet implemented")
    }
}