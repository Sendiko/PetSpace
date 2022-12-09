package com.sendiko.petspace.ui.container

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sendiko.petspace.repository.viewmodel.PetViewModel
import com.sendiko.petspace.ui.navigaton.SetupNavGraph
import com.sendiko.petspace.ui.theme.PetSpaceTheme
import com.sendiko.petspace.ui.theme.darkBlue

class MainActivity : ComponentActivity() {
    private lateinit var navController : NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetSpaceTheme {
                navController = rememberNavController()
                val viewModel : PetViewModel by viewModels()
                Scaffold(backgroundColor = darkBlue) {
                    SetupNavGraph(
                        navController = navController,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}