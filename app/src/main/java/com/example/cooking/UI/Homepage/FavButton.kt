package com.example.cooking.UI.Homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController


import androidx.compose.foundation.layout.padding

import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Tab
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector


import okhttp3.Route

@Composable
fun DisplayFavButton() {
    var isFavorite by remember { mutableStateOf(false) }


   /* val tabs = listOf(
        Tab(
            title = "Favorite",
            icon = if (isFavorite) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder
            , rootRoute = Route.Favorite
        )
    )*/

    Box(
        modifier = Modifier
            .fillMaxWidth(.15f)
            .aspectRatio(1f)
            .background(
                color = Color(0xFFC1DAE2),
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center,
    ) {
        IconButton(
            onClick = { isFavorite = !isFavorite }
        ) {
            if (isFavorite)
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favourite Heart Filled",
                    tint = Color.White

                )
            else
                Icon(
                    Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favourite Heart Outlined",
                    tint = Color.White
                )

/*
        NavigationBar {
            val isFavoritesTabSelected = navController.currentBackStack
                .collectAsState()
                .value
                .any{it.destination.route == Route.Favorite}
            tabs.forEach { tab ->
                NavigationBarItem(
                    icon = {
                        Icon(imageVector = tab.icon, contentDescription = null)
                    },
                    label = { Text(text = tab.title) },
                    selected = isFavoritesTabSelected, // Handle selection based on your use case
                    onClick = {

                      /*  isFavorite = !isFavorite
                        // Add your navigation logic here
                        val isTabSelected = if (tab.rootRoute == Route.RecipeList) {
                            !isFavoritesTabSelected
                        } else {
                            isFavoritesTabSelected
                        }*/
                    }
                )
            }*/



        }
    }
}
private data class Tab(
    val title: String,
    val icon: ImageVector,
    val rootRoute: Route
)
