package com.example.cooking.UI.SharedComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import coil.compose.AsyncImage
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
fun ImageWithFavIcon(imageUrl: String, onFavoriteButtonClicked: (String) -> Unit, isSquare: Boolean) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    Box(
       // contentAlignment = Alignment.BottomEnd
    ) {
        if(isSquare) {
            AsyncImage(
                model = imageUrl,
                contentDescription = null, //TODO give content description
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop,

                )
            /*Image(
                painter = painterResource(recipe.mainImage),
                contentDescription = recipe.imageDescription,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop,

                )*/
        } else {
            AsyncImage(
                model = imageUrl,
                contentDescription = null, //TODO give content description
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.92f),
                contentScale = ContentScale.Crop,

                )
           /* Image(
                painter = painterResource(recipe.mainImage),
                contentDescription = recipe.imageDescription,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.92f),
                contentScale = ContentScale.Crop,

                )*/
        }

        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .padding(16.dp)
        ) {
            DisplayFavButton()
        }

    }
}

@Preview
@Composable
fun previewImageWithFavIconRect() {
    ImageWithFavIcon("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/spiced-lentil-spinach-pies-a1ae301.jpg",
        { }, false)
}

/*@Preview
@Composable
fun previewImageWithFavIconSqr() {
    val recipeList = RecipeData().loadRecipes()
   // ImageWithFavIcon(recipe = recipeList[0], true)
}*/