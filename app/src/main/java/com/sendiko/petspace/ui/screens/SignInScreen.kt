package com.sendiko.petspace.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sendiko.petspace.ui.component.CustomTextField
import com.sendiko.petspace.ui.navigaton.Screens
import com.sendiko.petspace.ui.theme.cyan
import com.sendiko.petspace.ui.theme.darkBlue

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
                        color = Color.White
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
                labelText = "Email"
            )
            CustomTextField(
                textValue = password,
                borderColor = cyan,
                textColor = Color.White,
                paddingValue = 8,
                labelText = "Password"
            )
            Button(
                onClick = {
                    navController.navigate(Screens.HomeScreen.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp)
                    .height(64.dp),
                colors = ButtonDefaults.buttonColors(cyan)
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
