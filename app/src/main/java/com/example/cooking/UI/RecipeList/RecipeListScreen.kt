package com.example.cooking.UI.RecipeList

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.cooking.UI.Faviorite.FavoritesScreenViewModel

/**
 * Composable function `ListAllRecipesScreen` displays a list of recipes based on the specified
 * collection name. It interacts with a [RecipeListViewModel] to fetch and observe the list of
 * recipe cards for the given collection.
 *
 * @param collectionName The name of the recipe collection to display.
 * @param onNavigateToRecipe A callback function invoked when a user navigates to view a specific
 *                           recipe. It takes the recipe ID as a parameter.
 *
 * The composable performs the following tasks:
 * - Initializes a [RecipeListViewModel] to manage and provide data for the UI.
 * - Uses a [LaunchedEffect] to update the collection name or search keywords in the view model whenever the
 *   `collectionName`or "query" parameter changes.
 * - Observes the list of recipe cards from the view model using [collectAsState].
 * - Passes the observed list of recipes to the [RecipeList] composable for display.
 * @see RecipeListViewModel
 * @see RecipeList
 */
@Composable
fun ListAllRecipesScreen(
    collectionName:String,
    onNavigateToRecipe: (Int) -> Unit) {
    Log.v("CollectionName Trace", "CollectionName in List Screen Composable: $collectionName")
    val favoritesViewModel: FavoritesScreenViewModel = viewModel()
    val viewModel: RecipeListViewModel = viewModel()
    LaunchedEffect(key1 = collectionName){
        viewModel.updateCollectionName(collectionName)
    }

    val cards by viewModel.recipeCards.collectAsState()
    //val filters by viewModel.filters.collectAsState()
    //val isSelected by viewModel.isSelected.collectAsState()
    val buttonStates by viewModel.buttonStates.collectAsState()

    Column{
        FilterMenu(
            // filtersList = filters,
            // buttonStates = buttonStates,
            onSelect = { isSelected, tag ->
                viewModel.toggleButton(isSelected, tag)
            },

            onResetFilters = {
                viewModel.resetCardsList()
            },

            onApplyFilters = {
                viewModel.setCardsByTags()
            }
        )

        RecipeList(
            recipeCards = cards,
            onNavigateToRecipe = onNavigateToRecipe,
            onFavoriteButtonClicked = viewModel::onFavoriteButtonClicked,
            modifier = Modifier
                .padding(16.dp)
                .background(color = MaterialTheme.colorScheme.background)
                .fillMaxWidth()
        )
    }

}

// makeshift test...
/*@Preview
@Composable
fun TestTagFilterIsInTags(){
    val vm: RecipeListViewModel = viewModel()
    val tagsList = setOf("dairy_free", "gluten_free")
    val recipesCardList = loadTestCardsWithTags()
    val recipeCardList = vm.filterByTags(tagsList, recipesCardList)
    Column{
        Text(
            text = "Expecting card 'dairy-free gluten-free'"
        )
        recipeCardList.map{
            Text(
                text = it.name
            )
        }
    }


}

fun loadTestCardsWithTags(): List<RecipeCard> {

    val card1Tags = listOf(
        Tag(name = "dairy_free"),
        Tag(name = "gluten_free"),
        Tag(name = "easy")
    )

    val card2Tags = listOf(
        Tag(name = "asian"),
        Tag(name = "dairy_free")
    )
    return listOf(
        RecipeCard(
            name = "dairy-free gluten-free",
            tags = card1Tags
        ),
        RecipeCard(
            name = "asian dairy-free",
            tags = card2Tags
        )
    )
}

/*@Preview
@Composable
fun PreviewRecipeListScreen() {
    val viewModel: RecipeListViewModel = viewModel()
    val cards by viewModel.recipeCards.collectAsState()
    val cardsForCollection = loadTestCardsWithTags()

    Column{
        FilterMenu(
            onApplyFilters = { tagList ->
                viewModel.filterByTags(
                    tags = tagList,
                    recipeCards = cards
                )
            },
            onResetFilters = {
                Log.v("RecipeListScreen", "onResetFilters impl")
                viewModel.resetCardsList()
            }
        )
        RecipeList(recipeCards = cards, onNavigateToRecipe = {}, modifier = Modifier)

    }
}


@Composable
fun ListAllRecipes(query:String, onNavigateToRecipe: (Int) -> Unit) {

    Log.v("Recipes Trace", "RecipeId in viewModel.launch: $query")
    val viewModel: RecipeListViewModel = viewModel()
    LaunchedEffect( key1 = query){
        viewModel.updateSearchKey(query)
    }
    val recipes by viewModel.recipeCards.collectAsState()
    RecipeList(
        recipes = recipes,
        onNavigateToRecipe = onNavigateToRecipe,
    )
}*/