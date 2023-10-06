package com.example.cooking.UI.RecipePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.R

@Composable
fun RecipePageUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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

        CustomBoxWithText(title = "ingredients", body = "These are my ingredients.")
    }
}

@Composable
fun CustomBoxWithText(
    title: String,
    body: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color.Black)
    ) {
        Text(
            text = title.uppercase(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp),
        )

        Text(
            text = body,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 0.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        )
    }

}


@Preview
@Composable
fun PreviewRecipePage() {
    RecipePageUI()
}