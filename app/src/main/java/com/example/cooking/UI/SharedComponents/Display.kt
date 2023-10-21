package com.example.cooking.UI.SharedComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cooking.R
import com.example.cooking.data.RecipeData
import com.example.cooking.model.Recipe

@Composable
fun DisplayFavButton() {
    var isFavorite by remember { mutableStateOf(false) }
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
        }
    }
}

@Composable
fun ImageWithFavIcon(recipe: Recipe, isSquare: Boolean) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    Box(
        contentAlignment = Alignment.BottomEnd
    ) {
        if(isSquare) {
            Image(
                painter = painterResource(recipe.mainImage),
                contentDescription = recipe.imageDescription,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop,

                )
        } else {
            Image(
                painter = painterResource(recipe.mainImage),
                contentDescription = recipe.imageDescription,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.9f),
                contentScale = ContentScale.Crop,

                )
        }

        Box(
            modifier = Modifier
                .padding(22.dp)
        ) {
            DisplayFavButton()
        }

    }
}

@Preview
@Composable
fun previewImageWithFavIcon() {
    val recipeList = RecipeData().loadRecipes()
    ImageWithFavIcon(recipe = recipeList[0], false)
}