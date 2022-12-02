package com.sendiko.petspace.ui.screens

import android.annotation.SuppressLint
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sendiko.petspace.R
import com.sendiko.petspace.ui.component.LargeOutlinedButton
import com.sendiko.petspace.ui.component.LargeSolidButton
import com.sendiko.petspace.ui.navigaton.Screens
import com.sendiko.petspace.ui.theme.cyan
import com.sendiko.petspace.ui.theme.darkBlue
import com.sendiko.petspace.ui.theme.poppinsFamily

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
                        fontSize = 24.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LargeSolidButton(
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(Screens.SignInScreen.route)
                    },
                    horizontalPaddingValues = 16,
                    verticalPaddingValues = 4,
                    buttonColors = cyan,
                    buttonText = "Sign Up",
                    buttonTextColor = Color.White
                )
                LargeOutlinedButton(
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(Screens.SignInScreen.route)
                    },
                    horizontalPaddingValues = 16,
                    verticalPaddingValues = 8,
                    borderColor = cyan,
                    buttonColor = darkBlue,
                    buttonText = "Sign In",
                    buttonTextColor = Color.White
                )
            }
        }
    }
}