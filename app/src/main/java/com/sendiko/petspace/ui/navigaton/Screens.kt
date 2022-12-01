package com.sendiko.petspace.ui.navigaton

sealed class Screens(val route : String){
    object WelcomeScreen : Screens("welcome_screen")
}