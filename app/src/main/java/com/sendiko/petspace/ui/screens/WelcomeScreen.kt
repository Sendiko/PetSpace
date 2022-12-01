package com.sendiko.petspace.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
import com.sendiko.petspace.ui.navigaton.Screens
import com.sendiko.petspace.ui.theme.cyan
import com.sendiko.petspace.ui.theme.darkBlue

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WelcomeScreen(
    navController: NavHostController
) {
    Scaffold(
        backgroundColor = darkBlue
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.padding(top = 256.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(128.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.petspace),
                    contentDescription = null
                )
                Text(
                    text = "PetSpace",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 24.sp
                    )
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        navController.navigate(Screens.SignUpScreen.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                        .height(64.dp),
                    colors = ButtonDefaults.buttonColors(cyan)
                ) {
                    Text(
                        "Sign Up",
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    )
                }
                OutlinedButton(
                    onClick = {
                        navController.navigate(Screens.SignInScreen.route) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .height(64.dp),
                    border = BorderStroke(color = cyan, width = 2.dp),
                    colors = ButtonDefaults.buttonColors(darkBlue)
                ) {
                    Text(
                        "Sign In",
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    )
                }
            }
        }
    }
}