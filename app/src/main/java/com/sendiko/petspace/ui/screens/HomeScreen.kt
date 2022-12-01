package com.sendiko.petspace.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sendiko.petspace.R
import com.sendiko.petspace.ui.theme.darkBlue

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Scaffold(
        backgroundColor = darkBlue,
        topBar = {
            TopAppBar(
                backgroundColor = darkBlue,
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Hi, Sendiko!",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 24.sp
                        )
                    )
                    Text(
                        text = "Looking for soulmate?",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    )
                }
            }
        }
    ) {

    }
}