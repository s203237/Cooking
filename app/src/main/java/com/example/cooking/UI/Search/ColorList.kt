package com.example.cooking.UI.Search

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/*@Composable
fun ColorList(): List<String>{
    return listOf(

        "#FFF5DEB3", "#FFF0FFFF", "#FFFFEFD5",
        "#FFE6E6FA", "#FFF5F5DC", "#FFFDF5E6",
        "#FFFFF5EE", "#FFF0E68C", "#FFFFEBCD", "#FFEEE8AA"

        )

}*/

@Composable
fun ColorList(): List<Color> {
    return listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.tertiary,
        MaterialTheme.colorScheme.inversePrimary,
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.tertiary,
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.inversePrimary,
        MaterialTheme.colorScheme.primary
    )
}