package com.example.cooking.UI.SharedComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
fun ImageWithFavIcon(
    recipeId: String,
    imageUrl: String,
    onNavigateToRecipe: (String) -> Unit,
    onFavoriteButtonClicked: (String) -> Unit,
    cardFormat: CardFormats
) {
    Box(
       // contentAlignment = Alignment.BottomEnd
    ) {
        val aspectRatio: Float = when(cardFormat) {
            CardFormats.SQUARE -> 1f
            CardFormats.LANDSCAPE -> 2f
            CardFormats.PORTRAIT -> 0.92f
        }

        AsyncImage(
            model = imageUrl,
            contentDescription = null, //TODO give content description
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(aspectRatio)
                .clickable {
                    onNavigateToRecipe(recipeId)
                },
            contentScale = ContentScale.Crop,

            )

        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(aspectRatio)
                .padding(16.dp)
        ) {
            DisplayFavButton()
        }

    }
}

@Preview
@Composable
fun previewImageWithFavIconPortrait() {
    ImageWithFavIcon(
        "spiced-lentil-spinach-pies",
        "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/spiced-lentil-spinach-pies-a1ae301.jpg",
        {},
        {},
        CardFormats.PORTRAIT
    )
}

@Preview
@Composable
fun previewImageWithFavIconLandscape() {
    ImageWithFavIcon(
        "spiced-lentil-spinach-pies",
        "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/spiced-lentil-spinach-pies-a1ae301.jpg",
        {},
        {},
        CardFormats.LANDSCAPE
    )
}

@Preview
@Composable
fun previewImageWithFavIconSqr() {
    ImageWithFavIcon(
        "spiced-lentil-spinach-pies",
        "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/spiced-lentil-spinach-pies-a1ae301.jpg",
        {},
        {},
        CardFormats.SQUARE
    )
}

