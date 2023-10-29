package com.example.cooking.UI.topBar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(showTopBar: Boolean = true) {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }
    val menuItems = listOf(
        "Dinner", "Breakfast", "Lunch", "Dessert", "Snacks", "Soup",
        "Vegan", "One-Pot Meal", "High Protein", "Under 30 min", "Weeknight Dinner",
        "Appetizers", "Seasonal"
    )
    Scaffold(
        modifier = Modifier.fillMaxSize(),
            topBar = {
                if (showTopBar) {
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
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu Icon"
                            )
                        }
                    }

                )
            }
        }
    ){paddingValues ->
        Modifier.padding(paddingValues)
        TextField(
            value =selectedItem ,
            onValueChange = {
                selectedItem=it
                expanded=true
            }, singleLine = true,
            label={ Text(text = "menu")},
            //modifier=Modifier.padding(16.dp)
        )
        if(expanded){
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded=false },
           // modifier = Modifier.size(200.dp)
        ) {menuItems.forEach{item ->
            DropdownMenuItem(
                text = {Text(item)},
                onClick = {  selectedItem = item
                expanded = false
                }
            )
          }
        }
     }
   }
}
@Preview
@Composable
fun DefaultPreview(){
    MyTopBar()
}