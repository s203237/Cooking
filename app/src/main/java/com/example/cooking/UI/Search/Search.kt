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
import com.example.cooking.DependencyProvider
import com.example.cooking.UI.RecipeList.ListAllRecipes
import com.example.cooking.model.RecipeCard


@Composable
fun SearchBar(onNavigateToRecipe:(Int)-> Unit) {
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
            DisplayTextBoxes(
               onClickButton = {text ->setSearchQuery(text)
                   setOnSearchValue(true)}
            )
        }

    } else {
        ListAllRecipes(query = searchQuery, onNavigateToRecipe = onNavigateToRecipe
         )
    }

}

suspend fun callRecipeList(query: String): List<RecipeCard> {
    val listRepoCard = DependencyProvider.recipeCardsRepoSearch.fetchData(query)
    return listRepoCard
}

@Preview
@Composable
fun PreviewSearchBar() {
    SearchBar({})
}