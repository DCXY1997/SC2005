package com.example.roadguardian20

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roadguardian20.pages.HomePage
import com.example.roadguardian20.pages.LoginPage
import com.example.roadguardian20.pages.MainScreen
import com.example.roadguardian20.pages.SignupPage

@Composable
fun AppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginPage(modifier = modifier, navController = navController, authViewModel = authViewModel)
        }
        composable("signup") {
            SignupPage(modifier = modifier, navController = navController, authViewModel = authViewModel)
        }
        composable("main") {
            MainScreen(modifier = modifier, navController = navController, authViewModel = authViewModel)
        }
    }
}
