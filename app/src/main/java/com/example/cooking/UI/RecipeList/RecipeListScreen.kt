package com.example.cooking.UI.RecipeList

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import android.util.Log
import androidx.compose.runtime.LaunchedEffect

@Composable
fun ListAllRecipesScreen(collectionName:String, onNavigateToRecipe: (String) -> Unit) {
    Log.v("CollectionName Trace", "RecipeId in viewModel.launch: $collectionName")
    val viewModel: RecipeListViewModel = viewModel()
    LaunchedEffect(key1 = collectionName){
        viewModel.updateCollectionName(collectionName)
    }
    val recipes by viewModel.recipeCards.collectAsState()
    RecipeList(
        recipes = recipes,
        onNavigateToRecipe = onNavigateToRecipe,
    )

}