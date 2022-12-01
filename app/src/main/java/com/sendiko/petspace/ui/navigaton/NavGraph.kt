package com.sendiko.petspace.ui.navigaton

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sendiko.petspace.ui.screens.HomeScreen
import com.sendiko.petspace.ui.screens.SignInScreen
import com.sendiko.petspace.ui.screens.SignUpScreen
import com.sendiko.petspace.ui.screens.WelcomeScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.WelcomeScreen.route
    ){
        composable(
            route = Screens.WelcomeScreen.route
        ){
            WelcomeScreen(
                navController = navController
            )
        }
        composable(
            route = Screens.SignUpScreen.route
        ){
            SignUpScreen(
                navController = navController
            )
        }
        composable(
            route = Screens.SignInScreen.route
        ){
            SignInScreen(
                navController = navController
            )
        }
        composable(
            route = Screens.HomeScreen.route
        ){
            HomeScreen(
                navController = navController
            )
        }
    }
}