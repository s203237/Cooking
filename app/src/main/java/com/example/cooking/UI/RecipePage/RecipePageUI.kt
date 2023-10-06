package com.example.cooking.UI.RecipePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.R

@Composable
fun RecipePageUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box() {
            Image(
                painter = painterResource(R.drawable.pear),
                contentDescription = "A 3d rendered green pear with a rainbow on over it",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(360.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "My recipe title",
                fontSize = 24.sp,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(100.dp)
                    .border(2.dp, Color.Black),
            ) {
                Text(
                    text = "1 h 15",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.Center)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .border(2.dp, Color.Black)
            ) {
                Text(
                    text = "4 servings",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.Center)
                )
            }

        }
    }
}


@Preview
@Composable
fun PreviewRecipePage() {
    RecipePageUI()
}