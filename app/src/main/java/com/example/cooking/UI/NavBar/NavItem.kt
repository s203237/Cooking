package com.example.cooking.UI.NavBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.cooking.UI.NavBar.navigation.Screens

data class NavItem(
    val label : String,
    val icon: ImageVector,
    val route : String,
    val badgeCount: Int=0

)
val listOfNavItem: List<NavItem> = listOf(
    NavItem(
        label="Home",
        icon= Icons.Default.Home,
        route= Screens.HomeScreen.name

    ),
    NavItem(
        label="Search",
        icon= Icons.Default.Search,
        route= Screens.SearchScreen.name

    ),
    NavItem(
        label="Favorites",
        icon= Icons.Default.Favorite,
        route= Screens.Favorites.name

    ),
    NavItem(
        label="Login",
        icon= Icons.Default.Person,
        route= Screens.Profile.name

    )
)
