package com.sendiko.petspace.ui.navigaton

sealed class Screens(val route : String){
    object WelcomeScreen : Screens("welcome_screen")
    object SignUpScreen : Screens("signup_screen")
    object SignInScreen : Screens("signin_screen")
    object HomeScreen : Screens("home_screen")
    object PetDetailScreen : Screens("petdetail_screen")
}