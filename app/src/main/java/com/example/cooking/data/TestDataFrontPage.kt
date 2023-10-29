package com.example.cooking.data

import com.example.cooking.R
import com.example.cooking.model.Recipe



    fun dailyRecipe(): Recipe{
       val recipeList = RecipeData().loadRecipes()
        return recipeList[0]
    }

    fun loadCat1Recipes(): List<Recipe> {
        return RecipeData().loadRecipes()

    }

    fun loadCat2Recipes(): List<Recipe> {
        return RecipeData().loadRecipes()
    }

    fun loadCat3Recipes(): List<Recipe> {
        return RecipeData().loadRecipes()
    }

    fun loadCat4Recipes(): List<Recipe> {
        return RecipeData().loadRecipes()
    }

    fun loadCat5Recipes(): List<Recipe> {
        return RecipeData().loadRecipes()
    }
