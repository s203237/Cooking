package com.example.cooking.ui.Frontpage

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cooking.R
import com.example.cooking.model.Frontpage.RecipeModel

@Composable
fun RecipeCard(
    data: RecipeModel,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { Log.d("RecipeCard", "You clicked ${data.name}") }
    ) {
        Text(
            text = data.name,
            modifier = Modifier.padding(all = 8.dp)
        )
    }
}

@Preview
@Composable
fun CardPreview() {
    RecipeCard(data = RecipeModel(R.string.affirmation1, R.drawable.image1, "1"))
}