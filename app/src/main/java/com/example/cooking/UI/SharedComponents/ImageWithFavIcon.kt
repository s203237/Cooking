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
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cooking.model.RecipeCard

@Composable
fun RecipeImage(
    recipeId: Int,
    imageUrl: String,
    onNavigateToRecipe: (Int) -> Unit,
    //onFavoriteButtonClicked: (RecipeCard) -> Unit,
    cardFormat: CardFormats,
    sizeFraction: Float = 1f

) {
    val aspectRatioImg: Float = when (cardFormat) {
        CardFormats.SQUARE -> 1f
        CardFormats.LANDSCAPE -> 2f
        CardFormats.PORTRAIT -> 0.92f
    }

    Box(
        Modifier.fillMaxWidth(sizeFraction)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null, //TODO give content description
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(aspectRatioImg)
                .clickable {
                    onNavigateToRecipe(recipeId)
                    //onFavoriteButtonClicked
                },
            contentScale = ContentScale.Crop,

            )
    }

}
@Composable
fun FavButton(sizeFraction: Float = 0.15f, isFavorite: Boolean, onClick: () -> Unit) {
//var isFavorite by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth(sizeFraction)
            .aspectRatio(1f)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center,
    ) {
        IconButton(
            onClick = onClick


            //onClick = {isFavorite = !isFavorite}


        ) {
            if (isFavorite)
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favourite Heart Filled",
                    tint = Color.Green
                )
            else
                Icon(
                    Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favourite Heart Outlined",
                    tint = Color.White
                )
        }
           /* val icon = if (isFavorite) {
                Icons.Default.Favorite
            } else {
                Icons.Default.FavoriteBorder
            }
            Icon(imageVector = icon, contentDescription = null)
        }*/
    }
}

@Composable
fun ImageWithFavIcon(
    recipeId: Int,
    imageUrl: String,
    isFavorite: Boolean,
    onNavigateToRecipe: (Int) -> Unit,
    onFavoriteButtonClicked: (RecipeCard) -> Unit,
    cardFormat: CardFormats

) {

    Box(
    ) {
        val aspectRatioFavBox: Float = when (cardFormat) {
            CardFormats.SQUARE -> 1f
            CardFormats.LANDSCAPE -> 2f
            CardFormats.PORTRAIT -> 1f
        }

        RecipeImage(
            recipeId = recipeId,
            imageUrl = imageUrl,
            onNavigateToRecipe = onNavigateToRecipe,
            cardFormat = cardFormat,
            )

        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(aspectRatioFavBox)
                .padding(16.dp)
        ) {
            FavButton(
                onClick = {
                          onFavoriteButtonClicked(recipeCard)
                          //onFavoriteButtonClicked
                },
                isFavorite = isFavorite,

            )
        }

    }
}

/*@Preview
@Composable
fun previewImageWithFavIconPortrait() {
    ImageWithFavIcon(
        0,
        "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/spiced-lentil-spinach-pies-a1ae301.jpg",
        isFavorite =false,
        {},
        {},
        CardFormats.PORTRAIT
    )
}*/

/*@Preview
@Composable
fun previewImageWithFavIconLandscape() {
    ImageWithFavIcon(
        0,
        "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/spiced-lentil-spinach-pies-a1ae301.jpg",
       isFavorite = false,
        {},
        {},
        CardFormats.LANDSCAPE
    )
}*/

/*@Preview
@Composable
fun previewImageWithFavIconSqr() {
    ImageWithFavIcon(
        0,
        "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/spiced-lentil-spinach-pies-a1ae301.jpg",
       isFavorite = false,
        {},
        {},
        CardFormats.SQUARE
    )
}*/

