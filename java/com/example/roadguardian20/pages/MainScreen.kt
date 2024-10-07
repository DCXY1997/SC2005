package com.example.roadguardian20.pages

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.roadguardian20.AuthViewModel
import com.example.roadguardian20.pages.HomePage
import com.example.roadguardian20.pages.ReportPage
import com.example.roadguardian20.pages.ProfilePage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier, navController: NavController, authViewModel: AuthViewModel) {
    val internalNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(internalNavController, authViewModel)
        }
    ) { innerPadding ->
        NavHost(
            navController = internalNavController,
            startDestination = "home",
            Modifier.padding(innerPadding)
        ) {
            composable("home") { HomePage(modifier, navController, authViewModel) }
            composable("report") { ReportPage() }
            composable("profile") { ProfilePage() }
        }
    }
}
