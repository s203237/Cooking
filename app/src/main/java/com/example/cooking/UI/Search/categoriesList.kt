package com.example.cooking.UI.Search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategoriesList(): List<String>{
    return listOf(
        "Easy"  , "Soap" , "Dinner" ,
        "Casserole" , "Pasta" , "Slow cooker"
    )

}

fun getCollectionName(tagTitle: String) : String {
    val collectionName : String = when (tagTitle){
        "Dinner" -> "vegetarian-dinner-recipes"
        "Easy"-> "easy-vegetarian-recipes"
        "Pasta" -> "vegetarian-pasta-recipes"
        "Slow cooker" -> "vegetarian-slow-cooker-recipes"
        "Soap" -> "vegetable-soup-recipes"
        "Casserole"->"vegetarian-casserole-recipes"
        else -> "default"

    }

    return collectionName;

}