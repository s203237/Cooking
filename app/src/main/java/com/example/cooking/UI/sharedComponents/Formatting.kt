package com.example.cooking.UI.sharedComponents

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Formatting {
    @Composable
    fun Heading(heading: String) {
        Text(
            text = heading.uppercase(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(
                    bottom = 8.dp,
                    top = 16.dp
                )
        )
    }

}