package com.example.cooking.UI.Search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*


@Composable
fun SearchPage(onNavigateToRecipieList: (String) -> Unit) {
    val (searchQuery, setSearchQuery) = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        // First Part (SearchBar)
        //SearchBar(modifier = Modifier.weight(1f))
        // Spacer to create a division
        SearchBox(query = searchQuery, onQueryChange = { newQuery ->
            setSearchQuery(newQuery)
        } , onSearch = { /*TODO*/ },
           // active = true, // Or false based on your needs
            //onActiveChange = { isActive ->
                // Handle active state change here
            //}
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp) // Add padding from the top of the screen
                .background(Color.White)

        ) {
            DisplayTextBoxes(onNavigateToRecipieList)
        }

    }
@Preview
@Composable
fun PreviewSearchBar(){
    SearchPage(onNavigateToRecipieList = {})
}