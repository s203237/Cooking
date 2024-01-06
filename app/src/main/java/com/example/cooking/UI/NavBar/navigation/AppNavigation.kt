package com.example.cooking.UI.NavBar.navigation
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cooking.UI.AccountCreationPage.AccountCreationPage
import com.example.cooking.UI.Homepage.HomepageScreen
import com.example.cooking.UI.NavBar.listOfNavItem
import com.example.cooking.UI.Onboarding.OnBoardingPage
import com.example.cooking.UI.Profile.ProfileBox
import com.example.cooking.UI.RecipeList.ListAllRecipesScreen
import com.example.cooking.UI.RecipePage.DisplayRecipeScreen
import com.example.cooking.UI.Search.SearchBar
import kotlinx.coroutines.flow.StateFlow

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
 * @see SearchBar
 * @see ListAllRecipesScreen
 * @see ProfileBox
 * @see DisplayRecipeScreen
 */
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun AppNavigation(){
            val navController = rememberNavController()
            var displayBottomBar by remember { mutableStateOf(false) }
            var displayTopBar by remember { mutableStateOf(false) }
            var expanded by remember { mutableStateOf(false) }
            var selectedItem by remember { mutableStateOf("") }
            val menuItems = listOf(
                "Dinner", "Breakfast", "Lunch", "Dessert", "Snacks", "Soup",
                "Vegan", "One-Pot Meal", "High Protein", "Under 30 min", "Weeknight Dinner",
                "Appetizers", "Seasonal"
            )
            val commonRoute = Screens.Favorites.name
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    if (displayTopBar) {
                        CenterAlignedTopAppBar(
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.background,
                                titleContentColor = MaterialTheme.colorScheme.onBackground
                            ),
                            title = {
                                Text(
                                    text = "vegelicious",
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            },
                            navigationIcon = {
                                IconButton(onClick = { navController.popBackStack() }) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowBack,
                                        contentDescription = "Go Back Icon"
                                    )
                                }
                            },
                            actions = {
                                IconButton(onClick = { expanded = true }) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = "Menu Icon"
                                    )
                                }

                                DropdownMenu(
                                    expanded = expanded,
                                    onDismissRequest = { expanded = false },
                                    modifier = Modifier.fillMaxWidth(0.75f)
                                ) {
                                    menuItems.forEach { item ->
                                        DropdownMenuItem(
                                            text = {
                                                Text(
                                                    text = item,
                                                    fontSize = 22.sp,
                                                    textAlign = TextAlign.Center
                                                )
                                            },

                                            onClick = {
                                                selectedItem = item
                                                expanded = false
                                                navController.navigate(route = commonRoute)
                                            }

                                        )
                                    }
                                }
                            }

                        )
                    }
                }, bottomBar = {
                    if (displayBottomBar) {
                        NavigationBar(
                                containerColor = MaterialTheme.colorScheme.onSecondary,
                                contentColor = MaterialTheme.colorScheme.onBackground

                            ) {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            listOfNavItem.forEach { navItem ->
                                NavigationBarItem(
                                    selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                                    onClick = {
                                        navController.navigate(navItem.route) {
                                            /* popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }*/
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
                                   /* label = {
                                        Text(text = navItem.label)
                                    },*/
                                    colors = NavigationBarItemDefaults.colors(
                                        indicatorColor = MaterialTheme.colorScheme.secondary)
                                )
                            }
                        }
                    }
                }
            ) { paddingValues ->
                NavHost(
                    navController = navController,
                    startDestination = Screens.SearchScreen.name,
                    modifier = Modifier
                        .padding(paddingValues)
                ) {
                    composable(route = Screens.Onboarding.name) {
                        displayBottomBar = false
                        displayTopBar = false

                        OnBoardingPage(
                            onNavigateToAccountCreation = {
                                navController.navigate(
                                    route = Screens.AccountCreation.name
                                )
                            }
                        )
                        //printBackStack(navController.currentBackStack, "On boarding: ")
                    }

                    composable(route = Screens.AccountCreation.name) {
                        displayBottomBar = false
                        displayTopBar = false
                        AccountCreationPage(
                            onNavigateToHomeScreen = {
                                navController.navigate(
                                    route = Screens.HomeScreen.name
                                )
                            }
                        )
                        //printBackStack(navController.currentBackStack, "Account creation page: ")
                    }
                    composable(route = Screens.HomeScreen.name) {
                        displayBottomBar = true
                        displayTopBar = true
                        HomepageScreen(onNavigateToRecipe = { recipeId ->
                            navController.navigate(route = "Screens.RecipeItem.name/$recipeId")
                        })
                       // printBackStack(navController.currentBackStack, "Home screen: ")
                    }
                    composable(route = Screens.SearchScreen.name) {
                        displayBottomBar = true
                        displayTopBar = true
                        SearchBar(onSearch = { query ->
                            navController.navigate(route = "Screens.RecipeList.name/$query"
                            )
                        }/*onNavigateToRecipe = { recipeId ->
                            navController.navigate(route = "Screens.RecipeItem.name/$recipeId")
                            }*/
                        )
                        //PreviewSearchBar()
                        //printBackStack(navController.currentBackStack, "Preview: ")
                    }
                    composable(
                        route = Screens.Favorites.name,
                        //arguments = listOf(navArgument("collectionName") { type = NavType.StringType })
                    ) {//backStackEntry ->
                        // val collectionName = backStackEntry.arguments?.getString("collectionName")
                        // if(collectionName != null) {
                        ListAllRecipesScreen("salad",
                            onNavigateToRecipe = { recipeId ->
                                navController.navigate(route = "Screens.RecipeItem.name/$recipeId")
                            })
                        Log.v("In favs", "salad")
                        displayBottomBar = true
                        displayTopBar = true
                        //printBackStack(navController.currentBackStack, "Favourites: ")
                        /*} else {
                    Text("Collection not found")
                }*/
                    }

                    composable(
                        route = "Screens.RecipeList.name/{collectionName}",
                        arguments = listOf(navArgument("collectionName") {
                            type = NavType.StringType
                        })
                    ) { backStackEntry ->
                        val collectionName = backStackEntry.arguments?.getString("collectionName")
                        Log.v("Navigation", "In RecipeList, coll name : $collectionName")
                        if (collectionName != null) {
                            ListAllRecipesScreen(collectionName,
                                onNavigateToRecipe = { recipeId ->
                                    navController.navigate(route = "Screens.RecipeItem.name/$recipeId")
                                })
                           // printBackStack(navController.currentBackStack, "Recipe List: ")
                        } else {
                            Text("Collection not found")
                        }
                        displayBottomBar = true
                        displayTopBar = true
                    }
                    composable(route = Screens.Profile.name) {
                        displayBottomBar = true
                        displayTopBar = true
                        ProfileBox()
                        //printBackStack(navController.currentBackStack, "Profile: ")
                    }


                    composable(
                        route = "Screens.RecipeItem.name/{recipeId}",
                        arguments = listOf(navArgument("recipeId") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val recipeId = backStackEntry.arguments?.getString("recipeId")
                        if (recipeId != null) {
                            DisplayRecipeScreen(recipeId)
                           // printBackStack(navController.currentBackStack, "Recipe Screen: ")
                        } else {
                            Text("Recipe not found")
                        }
                        displayBottomBar = true
                        displayTopBar = true
                    }
                }

    }
}

fun printBackStack(entryList : StateFlow<List<NavBackStackEntry>>, screenName: String) {

    for(entry in entryList.value){
        val stringEntry =  entry.toString()
        Log.v("Backstack" , "$screenName: $stringEntry")

    }

    for (entry in entryList.value) {
        val stringEntry = entry.destination.route ?: "Unknown route"
        Log.v("Backstack", "Entry: $stringEntry")
    }


}






