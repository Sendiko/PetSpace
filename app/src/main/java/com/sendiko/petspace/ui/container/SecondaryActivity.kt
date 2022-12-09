package com.sendiko.petspace.ui.container

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sendiko.petspace.ui.navigaton.SecondNavGraph
import com.sendiko.petspace.ui.theme.PetSpaceTheme
import com.sendiko.petspace.ui.theme.lightBlueAlternative

class SecondaryActivity : ComponentActivity() {
    private lateinit var navController : NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetSpaceTheme {
                navController = rememberNavController()
                Scaffold(
                    backgroundColor = lightBlueAlternative
                ) {
                    SecondNavGraph(navController = navController)
                }
            }
        }
    }
}