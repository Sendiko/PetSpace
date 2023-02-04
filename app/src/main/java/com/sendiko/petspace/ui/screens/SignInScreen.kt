package com.sendiko.petspace.ui.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sendiko.petspace.repository.viewmodel.AuthViewModel
import com.sendiko.petspace.ui.component.CustomTextField
import com.sendiko.petspace.ui.component.LargeSolidButton
import com.sendiko.petspace.ui.component.RegularTopAppBar
import com.sendiko.petspace.ui.navigaton.Screens
import com.sendiko.petspace.ui.theme.cyan
import com.sendiko.petspace.ui.theme.darkBlue
import com.sendiko.petspace.ui.theme.poppinsFamily

@Composable
fun SignInScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf(true) }
    var inputIsNotValid by remember { mutableStateOf(false) }

    Scaffold(
        backgroundColor = darkBlue,
        topBar = {
            RegularTopAppBar(
                backgroundColor = darkBlue,
                title = "Sign In"
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
            CustomTextField(
                textValue = email,
                onNewValue = { newValue ->
                    email = newValue
                    when {
                        newValue.isNotEmpty() -> inputIsNotValid = false
                    }
                },
                borderColor = cyan,
                labelText = "Email",
                textColor = Color.White,
                paddingValue = 8,
                keyboardType = KeyboardType.Email,
                inputPassword = false,
                singleLine = true,
                placeholder = "Email",
                isError = inputIsNotValid,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Email,
                        contentDescription = null
                    )
                },
                trailingIcon = {}
            )
            CustomTextField(
                textValue = password,
                onNewValue = { password = it },
                borderColor = cyan,
                labelText = "Password",
                textColor = Color.White,
                paddingValue = 8,
                keyboardType = KeyboardType.Password,
                inputPassword = isVisible,
                singleLine = true,
                placeholder = "Password",
                isError = inputIsNotValid,
                trailingIcon = {
                    when (isVisible) {
                        true -> Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                isVisible = !isVisible
                            }
                        )
                        else -> Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                isVisible = !isVisible
                            }
                        )
                    }
                },
                leadingIcon = { Icon(imageVector = Icons.Rounded.Lock, contentDescription = null) }
            )
            when (inputIsNotValid) {
                true -> "Please check the data"
                else -> null
            }?.let { errorMessage ->
                Text(
                    text = errorMessage,
                    style = TextStyle(
                        color = Color.Red,
                        fontSize = 14.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Start
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                )
            }
            LargeSolidButton(
                onClick = {
                    authViewModel.validateSignIn(email, password)
                    val TAG = "VALIDATION"
                    when (authViewModel.signInValid.value) {
                        true -> {
                            navController.popBackStack()
                            navController.navigate(Screens.HomeScreen.route)
                        }
                        else -> {
                            inputIsNotValid = true
                        }
                    }
                    Log.i(TAG, "SignInScreen: $email, $password")
                },
                horizontalPaddingValues = 0,
                verticalPaddingValues = 32,
                buttonColors = cyan,
                buttonText = "Sign In",
                buttonTextColor = Color.White
            )
            Text(text = "Don't have account? Sign up here",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    textDecoration = TextDecoration.Underline
                ),
                modifier = Modifier.clickable {
                    navController.popBackStack()
                    navController.navigate(Screens.SignUpScreen.route)
                }
            )
        }
    }
}
