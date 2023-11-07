package com.example.cooking.UI.Search


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.rememberNavController
import com.example.cooking.R
import com.example.cooking.UI.NavBar.navigation.Navigator
import com.example.cooking.UI.NavBar.navigation.Screens


@Composable
fun SearchBar() {
    val navController = rememberNavController()
    val (searchQuery, setSearchQuery) = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(){
            IconButton(onClick = {
                Navigator.navController.navigate(route = Screens.HomeScreen.name){
                    popUpTo(0)
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = "",
                    tint = Color.Black,
                    modifier = Modifier
                )}
                Spacer(modifier = Modifier.width(40.dp))

                Text(
                    modifier = Modifier.height(55.dp),
                    text = "vegelicious",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold

                )

        }
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
                .padding(top = 130.dp) // Add padding from the top of the screen
                .background(Color.White)

        ) {
            DisplayTextBoxes()
        }

    }
@Preview
@Composable
fun PreviewSearchBar(){
    SearchBar()
}