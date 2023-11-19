package com.example.cooking.model


class FoodCategories(private val categoryName: String, private val categoryListOfRecipe: List<RecipeCard>) {

    fun getName(): String{
        return categoryName
    }

    fun getList(): List<RecipeCard>{
        return categoryListOfRecipe
    }

}