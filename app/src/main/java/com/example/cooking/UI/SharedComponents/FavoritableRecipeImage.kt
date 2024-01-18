package com.example.cooking.UI.SharedComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun ImageWithFavIcon(
    recipeCard: RecipeCard,
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
            recipeId = recipeCard.id,
            imageUrl = recipeCard.thumbnail_url,
            onNavigateToRecipe = onNavigateToRecipe,
            cardFormat = cardFormat,
        )
        //val recipeCard = RecipeCard() // what's this? A blank recipe card?
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(aspectRatioFavBox)
                .padding(16.dp)
        ) {
            FavButton(
                recipeCard = recipeCard,
                onFavoriteButtonClicked = onFavoriteButtonClicked,
                isFavorite = recipeCard.isFavorite,

                )
        }

    }
}

@Composable
fun RecipeImage(
    recipeId: Int,
    imageUrl: String,
    onNavigateToRecipe: (Int) -> Unit,
    cardFormat: CardFormats,
    modifier: Modifier = Modifier.fillMaxWidth()

) {
    val aspectRatioImg: Float = when (cardFormat) {
        CardFormats.SQUARE -> 1f
        CardFormats.LANDSCAPE -> 2f
        CardFormats.PORTRAIT -> 0.9f
    }

    Box(
        modifier = modifier
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null, //TODO give content description
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(aspectRatioImg)
                .clickable {
                    onNavigateToRecipe(recipeId)
                },
            contentScale = ContentScale.Crop,

            )
    }

}
@Composable
fun FavButton(
    isFavorite: Boolean,
    recipeCard: RecipeCard,
    onFavoriteButtonClicked: (RecipeCard) -> Unit,
) {
//var isFavorite by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .width(50.dp)
            //.fillMaxWidth(0.35f)
            .aspectRatio(1f)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center,
    ) {
        IconButton(
            onClick = { onFavoriteButtonClicked(recipeCard) }


            //onClick = {isFavorite = !isFavorite}


        ) {
            if (isFavorite)
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favourite Heart Filled",
                    tint = MaterialTheme.colorScheme.onPrimary
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

