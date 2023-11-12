package com.example.cooking.UI.NavBar.navigation

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
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cooking.UI.AccountCreationPage.AccountCreationPage
import com.example.cooking.UI.Homepage.PreviewscrollableList
import com.example.cooking.UI.NavBar.listOfNavItem
import com.example.cooking.UI.Onboarding.OnBoardingPage
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.cooking.R
import com.example.cooking.UI.Login.ProfileBox
import com.example.cooking.UI.Profile.ProfileBox
import com.example.cooking.UI.RecipeList.RecipeList
import com.example.cooking.UI.RecipePage.RecipePage
import com.example.cooking.data.RecipeData
import java.lang.Exception


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    try {
        Navigator.navController = navController
    } catch (e: Exception) {
        e.printStackTrace()
    }
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
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary),
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
                        IconButton(onClick = {expanded=true }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu Icon"
                            )
                        }

                        DropdownMenu(
                            expanded =expanded,
                            onDismissRequest ={expanded=false},
                            modifier=Modifier.fillMaxWidth(0.75f)){
                            menuItems.forEach { item ->
                                DropdownMenuItem(
                                    text = { Text(
                                        text = item,
                                        fontSize = 22.sp,
                                        textAlign = TextAlign.Center) },

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
            navController =navController ,
            startDestination = Screens.Onboarding.name,
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
            composable(route = Screens.HomeScreen.name) {
                displayBottomBar = true
                PreviewscrollableList()
            }
            composable(route = Screens.SearchScreen.name) {
                //SearchPage()
                PreviewSearchBar()
            }
            composable(route = Screens.Favorites.name) {
                RecipeList(
                    onNavigateToRecipe = { index ->
                        navController.navigate(
                            route = "Screens.RecipeItem.name/$index"
                        )
                    }
                )
            }
            composable(route = Screens.Profile.name) {
                ProfileBox()
            }
            val recipeList = RecipeData().loadRecipes()
            composable(
                route = "Screens.RecipeItem.name/{recipeId}",
                arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
            ) { backStackEntry ->
                val recipeId = backStackEntry.arguments?.getInt("recipeId")
                if (recipeId != null) {
                    RecipePage(recipe = recipeList[recipeId])
                } else {
                    // Handle the case where the recipe doesn't exist
                    Text("Recipe not found")
                }
            }
        }

    }

        }
}






