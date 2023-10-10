package com.example.cooking.UI.Search

import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.filament.Box
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.cooking.R


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
                .padding(16.dp),
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
                shape = RoundedCornerShape(30),

                     leadingIcon = {
                          
                     
                    Icon(
                        Icons.Outlined.Search,
                        contentDescription = null,
                        tint = Color.DarkGray
                    )
                
            
                     }  )
        }
    }
}

@Preview
@Composable
fun PreviewSearchBar(){

    SearchBar(modifier = Modifier.fillMaxSize()) 
//
    
}