package com.example.cooking.UI.Search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun  DisplayTextBoxes() {
    val categoriesList = CategoriesList()
    val colorList = ColorList()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        categoriesList.forEachIndexed { index, category ->
            val color = colorList.getOrNull(index)
            if (color != null) {
                val backgroundColor = Color(android.graphics.Color.parseColor(color))

                Box(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .background(backgroundColor)
                        .border(1.dp, Color.Gray, RoundedCornerShape(50.dp))

                ) {
                    Text(
                        text = category,
                        modifier = Modifier.padding(16.dp),
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                }
            }

        }
    }
}




