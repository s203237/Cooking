package com.example.cooking.UI.NavBar.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.cooking.UI.Login.TempLoginPage
import com.example.cooking.UI.NavBar.listOfNavItem
import com.example.cooking.UI.Search.PreviewSearchBar
import com.example.cooking.UI.RecipeList.RecipeList
import com.example.cooking.UI.Onboarding.OnBoardingPage
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.cooking.UI.Search.SearchPage

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppNavigation(){
    val navController= rememberNavController()
    var displayBottomBar by remember { mutableStateOf(false) }
    Scaffold (
        bottomBar = {
            if (displayBottomBar) {
                NavigationBar {
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
                            }
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

            composable(route=Screens.HomeScreen.name){
                displayBottomBar = true
                PreviewscrollableList()
            }
            composable(route=Screens.SearchScreen.name){
                SearchPage()
            }
            composable(route=Screens.Favorites.name){
                RecipeList()
            }
            composable(route=Screens.Profile.name){
                TempLoginPage()
            }
        }

    }

}
