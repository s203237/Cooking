package com.example.cooking.test

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick

import com.example.cooking.UI.NavBar.navigation.AppNavigation

import org.junit.Rule
import org.junit.Test
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.cooking.UI.NavBar.listOfNavItem


class TestNavigationBarActivity {
    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun navigationTest() {
        // Given I am on the homepage
        composeTestRule.setContent {
           AppNavigation(){
               NavigationBar {
                   listOfNavItem.forEach { navItem ->
                   NavigationBarItem(selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                       onClick = {
                           navController.navigate(navItem.route)

                   }

               }

           }

        }
        // I click the "Search" button on the navigation bar
        composeTestRule.onNodeWithTag("Search").performClick()

        // I should see the search screen
        composeTestRule.onNodeWithTag("searchtext").assertIsDisplayed()

    }


}
