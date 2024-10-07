package com.example.roadguardian20.pages

import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.roadguardian20.AuthViewModel

@Composable
fun BottomNavigationBar(navController: NavController, authViewModel: AuthViewModel) {
    val items = listOf(
        NavItem("Home", Icons.Default.Home, "home"),
        NavItem("Report", Icons.Default.Add, "report"),
        NavItem("Profile", Icons.Default.Person, "profile"),
        NavItem("Signout", Icons.Default.Person, "signout")
    )
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {

                    if(item.route == "signout"){
                        authViewModel.signout()
                    }
                    else{
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}

data class NavItem(val label: String, val icon: ImageVector, val route: String)
