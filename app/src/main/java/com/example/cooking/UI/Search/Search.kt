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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import com.example.cooking.DependencyProvider
import com.example.cooking.UI.NavBar.navigation.Navigator.navController
import com.example.cooking.UI.RecipeList.ListAllRecipes
import com.example.cooking.UI.RecipeList.RecipeList
import com.example.cooking.model.RecipeCard
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun SearchBar() {
    val (searchQuery, setSearchQuery) = remember { mutableStateOf("") }
    val (onSearching, setOnSearchValue) = remember { mutableStateOf(false) }
    if(onSearching !=true){
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            // First Part (SearchBar)
            //SearchBar(modifier = Modifier.weight(1f))
            // Spacer to create a division
            SearchBox(
                query = searchQuery,
                onQueryChange = { newQuery ->
                    setSearchQuery(newQuery)
                },
                onSearch = { query ->
                    setOnSearchValue(true)

                },
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

    } else {
        ListAllRecipes(query = searchQuery, onNavigateToRecipe = { recipeId ->
            navController.navigate(route = "Screens.RecipeItem.name/$recipeId")
        } )
    }

}

suspend fun callRecipeList(query: String): List<RecipeCard> {
    val listRepoCard = DependencyProvider.recipeCardsRepoSearch.fetchData(query)
    return listRepoCard
}


@Preview
@Composable
fun PreviewSearchBar() {
    SearchBar()
}