package com.example.cooking.UI.Search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    //search: String ,
    // onSearchChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    //onSearchSubmit: () ->Unit ={}
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        var search by remember { mutableStateOf(TextFieldValue()) }
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(30.dp)
                .background(color = Color.White),
            contentAlignment = Alignment.TopCenter

        ) {
            TextField(
                value = search,
                onValueChange = { text -> search = text },
                singleLine = true,
                textStyle = TextStyle(fontSize = 16.sp),

                placeholder = {
                    Text(
                        text = "Search here...",
                        color = Color.DarkGray

                    )
                },
                shape = RoundedCornerShape(50),
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Search,
                        contentDescription = null,
                        tint = Color.DarkGray
                    )

                }
            )
        }

    }

}