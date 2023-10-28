package com.example.cooking.UI.Search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.vision.text.Text

@Composable
fun CategoriesList(): List<String>{
    return listOf(
        "Salads" , "Dessert" , "Dinner" ,
        "Healthy" , "Pasta" , "Sides" ,
        "Breakfast" , "Easy" , "Under 45 min" , "1 hour",

    )

}