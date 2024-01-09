package com.example.cooking.UI.Homepage

import HomePageViewModel
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel



@Composable
fun HomepageScreen(onNavigateToRecipe: (String) -> Unit){
    val viewModel: HomePageViewModel = viewModel()

    val collection1 by viewModel.recipeCollection1.collectAsState()
    val collection2 by viewModel.recipeCollection2.collectAsState()
    val collection3 by viewModel.recipeCollection3.collectAsState()
    val collection4 by viewModel.recipeCollection4.collectAsState()
    val collection5 by viewModel.recipeCollection5.collectAsState()
    val dailyRecipe by viewModel.dailyRecipe.collectAsState()


    val collections = listOf(
        collection1,
        collection2,
        collection3,
        collection4,
        collection5,
    )

    //val collections by viewModel.recipeCollections.collectAsState()
    collections.forEach { coll ->
        Log.v("HomepageScreen", coll.collectionName)
    }

    scrollableList(
            modifier = Modifier
                .background(color = Color(0xFFF2ECE3))
                .padding(16.dp),
            dailyRecipe = dailyRecipe,
            listOfCollections = collections,
            onNavigateToRecipe = onNavigateToRecipe,
            onFavoriteButtonClicked = viewModel::onFavoriteButtonClicked
        )

}

