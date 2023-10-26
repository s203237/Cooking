package com.example.cooking.UI.topBar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "vegelicious",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Go Back Icon"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu Icon"
                        )
                    }
                }
            )
        }
    ){values -> 
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(values)
        ){
            item{
                Text(
                    text ="Dinner",
                    modifier = Modifier.padding(16.dp)
                )
            }
            item{
                Text(
                    text ="Breakfast",
                    modifier = Modifier.padding(16.dp)
                )
            }
            item{
                Text(
                    text ="Lunch",
                    modifier = Modifier.padding(16.dp)
                )
            }
            item{
                Text(
                    text ="Dessert",
                    modifier = Modifier.padding(16.dp)
                )
            }
            item{
                Text(
                    text ="Snacks",
                    modifier = Modifier.padding(16.dp)
                )
            }
            item{
                Text(
                    text ="Soup",
                    modifier = Modifier.padding(16.dp)
                )
            }
            item{
                Text(
                    text ="Vegan",
                    modifier = Modifier.padding(16.dp)
                )
            }
            item{
                Text(
                    text ="One-Pot Meal",
                    modifier = Modifier.padding(16.dp)
                )
            }
            item{
                Text(
                    text ="High Protein",
                    modifier = Modifier.padding(16.dp)
                )
            }
            item{
                Text(
                    text ="Under 30 min",
                    modifier = Modifier.padding(16.dp)
                )
            }
            item{
                Text(
                    text ="Weeknight Dinner",
                    modifier = Modifier.padding(16.dp)
                )
            }
            item{
                Text(
                    text ="Appetizers",
                    modifier = Modifier.padding(16.dp)
                )
            }
            item{
                Text(
                    text ="Seasonal",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

    }
}
@Preview
@Composable
fun DefaultPreview(){
    MyTopBar()
}