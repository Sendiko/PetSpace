package com.sendiko.petspace.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sendiko.petspace.ui.component.CustomTextField
import com.sendiko.petspace.ui.component.LargeSolidButton
import com.sendiko.petspace.ui.navigaton.Screens
import com.sendiko.petspace.ui.theme.cyan
import com.sendiko.petspace.ui.theme.darkBlue
import com.sendiko.petspace.ui.theme.poppinsFamily

@Composable
fun SignInScreen(
    navController: NavHostController
) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Scaffold(
        backgroundColor = darkBlue,
        topBar = {
            TopAppBar(
                backgroundColor = darkBlue,
                elevation = 0.dp,
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                Text(
                    text = "Sign In",
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.White,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTextField(
                textValue = email,
                borderColor = cyan,
                textColor = Color.White,
                paddingValue = 8,
                labelText = "Email",
                keyboardType = KeyboardType.Email,
                inputPassword = false,
                singleLine = true
            )
            CustomTextField(
                textValue = password,
                borderColor = cyan,
                textColor = Color.White,
                paddingValue = 8,
                labelText = "Password",
                keyboardType = KeyboardType.Password,
                inputPassword = true,
                singleLine = true
            )
            LargeSolidButton(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screens.HomeScreen.route)
                },
                horizontalPaddingValues = 0,
                verticalPaddingValues = 32,
                buttonColors = cyan,
                buttonText = "Sign In",
                buttonTextColor = Color.White
            )
        }
    }
}
