package com.sendiko.petspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sendiko.petspace.ui.navigaton.SetupNavGraph
import com.sendiko.petspace.ui.theme.PetSpaceTheme

class MainActivity : ComponentActivity() {
    private lateinit var navController : NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetSpaceTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}