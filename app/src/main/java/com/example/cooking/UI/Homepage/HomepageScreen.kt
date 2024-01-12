package com.example.cooking.UI.Homepage

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
import com.example.cooking.UI.Faviorite.FavoritesScreenViewModel


@Composable
fun HomepageScreen(onNavigateToRecipe: (Int) -> Unit){
    val viewModel: HomePageViewModel = viewModel()
    val collections by viewModel.recipeCollections.collectAsState()
    /*val collection1 by viewModel.recipeCollection1.collectAsState()
    val collection2 by viewModel.recipeCollection2.collectAsState()
    val collection3 by viewModel.recipeCollection3.collectAsState()
    val collection4 by viewModel.recipeCollection4.collectAsState()
    val collection5 by viewModel.recipeCollection5.collectAsState()*/
    val dailyRecipe by viewModel.dailyRecipe.collectAsState()
    val favoritesViewModel: FavoritesScreenViewModel = viewModel()
    val favorites by favoritesViewModel.favorites.collectAsState()


    /*val collections = listOf(
        collection1,
        collection2,
        collection3,
        collection4,
        collection5,
    )*/

    //val collections by viewModel.recipeCollections.collectAsState()
    collections.forEach { coll ->
        Log.v("HomepageScreen", coll.collectionName)
    }

//<<<<<<< HEAD
    scrollableList(
            modifier = Modifier
                .background(color = Color(0xFFF2ECE3))
                .padding(
                    start = 16.dp,
                    end = 16.dp
                ),
            dailyRecipe = dailyRecipe,
            listOfCollections = collections,
            onNavigateToRecipe = onNavigateToRecipe,
//=======
//    if(list.size > 0) {
//        val dailyRecipe = list[Random.nextInt(list.size)]
//
//        scrollableList(
//            dailyRecipe = dailyRecipe,
//            listOfList = listOfList,
//            onNavigateToRecipe =onNavigateToRecipe
//>>>>>>> main
            onFavoriteButtonClicked = viewModel::onFavoriteButtonClicked
        )

}

