package com.sendiko.petspace.ui.navigaton

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sendiko.petspace.repository.viewmodel.AuthViewModel
import com.sendiko.petspace.repository.viewmodel.PetViewModel
import com.sendiko.petspace.ui.screens.*

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    viewModel: PetViewModel,
    authViewModel: AuthViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screens.WelcomeScreen.route
    ) {
        composable(
            route = Screens.WelcomeScreen.route
        ) {
            WelcomeScreen(
                navController = navController
            )
        }
        composable(
            route = Screens.SignUpScreen.route
        ) {
            SignUpScreen(
                navController = navController,
                authViewModel = authViewModel
            )
        }
        composable(
            route = Screens.SignInScreen.route
        ) {
            SignInScreen(
                navController = navController,
                authViewModel = authViewModel
            )
        }
        composable(
            route = Screens.HomeScreen.route
        ) {
            HomeScreen(
                navController = navController,
                viewModel = viewModel,
            )
        }
        composable(
            route = Screens.PetDetailScreen.route
        ) {
            PetDetailScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}

@Composable
fun SecondNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.ProfileScreen.route
    ) {
        composable(
            Screens.ProfileScreen.route,
        ) {
            ProfileScreen(
                navController = navController
            )
        }
        composable(
            Screens.ChatListScreen.route
        ) {
            ChatListScreen(
                navController = navController
            )
        }
    }
}