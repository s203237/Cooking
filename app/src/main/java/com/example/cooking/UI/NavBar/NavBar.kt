/*package com.example.cooking.UI.NavBar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cooking.UI.Favorites.Favorites
import com.example.cooking.UI.Homepage.Homepage
import com.example.cooking.UI.Login.Login


@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
        com.example.cooking.UI.NavBar.Homepage()
        }
        composable("search"){
        Search()
        }
        composable("favorites"){
        com.example.cooking.UI.NavBar.Favorites()
        }
        composable("login"){
        com.example.cooking.UI.NavBar.Login()
        }


    }
}
@Composable
fun BottomNavigationBar(
    items:List<BottomNavItem> ,
    navController: NavController,
    modifier: Modifier=Modifier,
    onItemClick:(BottomNavItem) -> Unit

){
     NavigationBar(
        modifier = modifier,
        backgroundColor= Color.DarkGray,
         elevation=5.dp
    ){

    }

}

@Composable
fun Homepage(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "HomeScreen")
    }
}
@Composable
fun Search(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Search")
    }
}
@Composable
fun Favorites(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Favorites")
    }
}
@Composable
fun Login(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Login")
    }
}*/