package com.example.cooking.UI.SharedComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTitle(title: String, textAlign: TextAlign = TextAlign.Start) {
    Text(
        text = title,
        fontSize = 30.sp,
        textAlign = textAlign,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = 8.dp,
                top = 16.dp
            )
    )
}

@Composable
fun CustomHeading1(heading: String, textAlign: TextAlign = TextAlign.Start) {
    Text(
        text = heading.uppercase(),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        modifier = Modifier
            .padding(
                bottom = 8.dp,
                top = 22.dp
            )
    )
}

@Composable
fun CustomHeading2(heading: String, textAlign: TextAlign = TextAlign.Start) {
    Text(
        text = heading.uppercase(),
        fontSize = 12.sp,
        textAlign = textAlign,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = 8.dp,
                top = 22.dp
            )
    )
}