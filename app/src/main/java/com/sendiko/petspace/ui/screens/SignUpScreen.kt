package com.sendiko.petspace.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sendiko.petspace.ui.component.CustomOutlinedTextField
import com.sendiko.petspace.ui.component.LargeSolidButton
import com.sendiko.petspace.ui.component.RegularTopAppBar
import com.sendiko.petspace.ui.navigaton.Screens
import com.sendiko.petspace.ui.theme.cyan
import com.sendiko.petspace.ui.theme.darkBlue

@Composable
fun SignUpScreen(
    navController: NavHostController
) {
    var username by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var user by remember {
        mutableStateOf("")
    }

    Scaffold(
        backgroundColor = darkBlue,
        topBar = {
            RegularTopAppBar(
                backgroundColor = darkBlue,
                title = "Sign Up",
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomOutlinedTextField(
                textValue = username,
                borderColor = cyan,
                textColor = Color.White,
                paddingValue = 8,
                labelText = "Username",
                keyboardType = KeyboardType.Text,
                inputPassword = false,
                singleLine = true
            )
            CustomOutlinedTextField(
                textValue = email,
                borderColor = cyan,
                textColor = Color.White,
                paddingValue = 8,
                labelText = "Email",
                keyboardType = KeyboardType.Email,
                inputPassword = false,
                singleLine = true
            )
            CustomOutlinedTextField(
                textValue = password,
                borderColor = cyan,
                textColor = Color.White,
                paddingValue = 8,
                labelText = "Password",
                keyboardType = KeyboardType.Password,
                inputPassword = true,
                singleLine = true
            )
            CustomOutlinedTextField(
                textValue = user,
                borderColor = cyan,
                textColor = Color.White,
                paddingValue = 8,
                labelText = "User/Shelter",
                keyboardType = KeyboardType.Text,
                inputPassword = false,
                singleLine = true
            )
            LargeSolidButton(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screens.SignInScreen.route)
                },
                horizontalPaddingValues = 0,
                verticalPaddingValues = 32,
                buttonColors = cyan,
                buttonText = "Sign Up",
                buttonTextColor = Color.White
            )
        }
    }
}