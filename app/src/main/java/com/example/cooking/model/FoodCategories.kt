package com.example.cooking.model

import androidx.compose.runtime.Composable
import com.example.cooking.data.remote.RecipeCard

class FoodCategories(private val categoryName: String, private val categoryListOfRecipe: List<RecipeCard>) {

    //val name = categoryName
    //val listOfRecipe = categoryListOfRecipe

    fun getName(): String{
        return categoryName
    }

    fun getList(): List<RecipeCard>{
        return categoryListOfRecipe
    }

}