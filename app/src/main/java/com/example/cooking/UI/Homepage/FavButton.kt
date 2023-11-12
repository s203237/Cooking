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