package com.example.cooking.UI.NavBar.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cooking.UI.AccountCreationPage.AccountCreationPage
import com.example.cooking.UI.Homepage.PreviewscrollableList
import com.example.cooking.UI.NavBar.listOfNavItem
import com.example.cooking.UI.Search.PreviewSearchBar
import com.example.cooking.UI.Onboarding.OnBoardingPage
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.cooking.UI.Profile.ProfileBox
import com.example.cooking.UI.RecipeList.ListAllRecipesScreen
import com.example.cooking.UI.RecipeList.RecipeList
import com.example.cooking.UI.RecipePage.DisplayRecipeScreen
import com.example.cooking.UI.Search.SearchBar
import com.example.cooking.model.RecipeCard

/**
 * Composable function `AppNavigation` defines the navigation structure for the cooking app using
 * Jetpack Compose Navigation. It includes screens for onboarding, account creation, home, search,
 * favorites, profile, and displaying a detailed recipe. The navigation is facilitated by a
 * [NavHost], and a [Scaffold] is used to provide a common layout, including a bottom navigation bar.
 *
 * The bottom navigation bar includes icons and labels for different navigation items, and it is
 * dynamically updated based on the current destination. The composable uses a [NavigationBar] and
 * [NavigationBarItem] for this purpose.
 *
 * @see Screens
 * @see NavigationBar
 * @see NavigationBarItem
 * @see Scaffold
 * @see NavHost
 * @see OnBoardingPage
 * @see AccountCreationPage
 * @see PreviewscrollableList
 * @see PreviewSearchBar
 * @see ListAllRecipesScreen
 * @see ProfileBox
 * @see DisplayRecipeScreen
 */
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppNavigation(){
    val navController= rememberNavController()
    var displayBottomBar by remember { mutableStateOf(false) }
    Scaffold (
        bottomBar = {
            if (displayBottomBar) {
                NavigationBar() {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    listOfNavItem.forEach { navItem ->
                        NavigationBarItem(
                            selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                            onClick = {
                                navController.navigate(navItem.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = navItem.icon,
                                    contentDescription = null
                                )
                            },
                            label = {
                                Text(text = navItem.label)
                            },
                            //modifier = Modifier.background(color = Color(0xFF93BBCF))
                        )
                    }
                }
            }
        }
    ){paddingValues ->
        NavHost(
            navController = navController ,
            startDestination = Screens.Favorites.name,
            modifier= Modifier
                .padding(paddingValues)
        ){
            composable(route = Screens.Onboarding.name) {
                OnBoardingPage(
                    onNavigateToAccountCreation = {
                        navController.navigate(
                            route = Screens.AccountCreation.name
                        )
                    }
                )
            }

            composable(route = Screens.AccountCreation.name) {
                AccountCreationPage(
                    onNavigateToHomeScreen = {
                        navController.navigate(
                            route = Screens.HomeScreen.name
                        )
                    }
                )
            }

            composable(route=Screens.HomeScreen.name){
                displayBottomBar = true
                PreviewscrollableList()
            }
            composable(route=Screens.SearchScreen.name){
                SearchBar(onNavigateToRecipeList= {recipeCards: List<RecipeCard> ->
                    composable(route = "abcd") {
                        RecipeList(
                            recipes = recipeCards,
                            onNavigateToRecipe = { recipeId ->
                                navController.navigate(route = "Screens.RecipeItem.name/$recipeId")}
                        )
                    }
                } )
            }
            composable(
                route=Screens.Favorites.name,
                //arguments = listOf(navArgument("collectionName") { type = NavType.StringType })
            ){//backStackEntry ->
               // val collectionName = backStackEntry.arguments?.getString("collectionName")
               // if(collectionName != null) {
                    ListAllRecipesScreen("easy-vegetarian-recipes",
                        onNavigateToRecipe = { recipeId ->
                        navController.navigate(route = "Screens.RecipeItem.name/$recipeId")
                    })
                /*} else {
                    Text("Collection not found")
                }*/
            }

            composable(
                route=Screens.RecipeList.name, arguments = listOf(navArgument("collectionName") { type = NavType.StringType })
            ){backStackEntry ->
                 val collectionName = backStackEntry.arguments?.getString("collectionName")
                 if(collectionName != null) {
                ListAllRecipesScreen(collectionName,
                    onNavigateToRecipe = { recipeId ->
                        navController.navigate(route = "Screens.RecipeItem.name/$recipeId")
                    })
                } else {
                    Text("Collection not found")
                }
            }

            composable(route=Screens.Profile.name){
                ProfileBox()
            }

            composable(
                route = "Screens.RecipeItem.name/{recipeId}",
                arguments = listOf(navArgument("recipeId") { type = NavType.StringType })
            ) { backStackEntry ->
                val recipeId = backStackEntry.arguments?.getString("recipeId")
                if (recipeId != null) {
                   DisplayRecipeScreen(recipeId)
                } else {
                    Text("Recipe not found")
                }
            }
        }

    }

}
