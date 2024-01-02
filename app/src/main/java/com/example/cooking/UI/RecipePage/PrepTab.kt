package com.example.cooking.UI.RecipePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.R
import com.example.cooking.UI.SharedComponents.CustomHeading1
import com.example.cooking.model.Recipe


@Composable
fun PrepTab(recipe: Recipe) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.tab_left),
                contentDescription = "Left tab to view recipe information",
                alignment = Alignment.CenterStart,
            )
            Image(
                painter = painterResource(id = R.drawable.tab_right),
                contentDescription = "Right tab to view recipe information",
                modifier = Modifier
                    .fillMaxWidth(),
                alignment = Alignment.CenterEnd,
            )

        }

        Box (
            modifier = Modifier
                .fillMaxWidth()
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color(0xFFF2ECE3)
                    )
                    .padding(
                            top = 36.dp,
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 16.dp)
            ) {
                CustomHeading1(heading = "steps")
                StepsList(list = recipe.steps.values.toList())
            }

            Image(
                painter = painterResource(id = R.drawable.tab_right_ext),
                contentDescription = "Extension of the right tab",
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }


    }
}

@Composable
private fun StepsList(list: List<String>) {
    list.forEachIndexed { index, item ->
        val stepCount = index + 1
        Text(
            text = "Step $stepCount" ,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
        Text(
            text = item,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(
                    bottom = 16.dp
                )
        )
    }
}