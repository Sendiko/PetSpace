package com.sendiko.petspace.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sendiko.petspace.repository.model.InputError
import com.sendiko.petspace.repository.user.UserViewModel
import com.sendiko.petspace.repository.viewmodel.AuthViewModel
import com.sendiko.petspace.ui.component.CustomTextField
import com.sendiko.petspace.ui.component.LargeSolidButton
import com.sendiko.petspace.ui.component.RegularTopAppBar
import com.sendiko.petspace.ui.navigaton.Screens
import com.sendiko.petspace.ui.theme.cyan
import com.sendiko.petspace.ui.theme.darkBlue
import com.sendiko.petspace.ui.theme.poppinsFamily
import kotlinx.coroutines.CoroutineScope

@Composable
fun SignInScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    userViewModel: UserViewModel = UserViewModel()
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf(true) }
    var inputIsNotValid by remember { mutableStateOf(InputError(false, "")) }
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        backgroundColor = darkBlue,
        topBar = {
            RegularTopAppBar(
                backgroundColor = darkBlue,
                title = "Sign In"
            )
        },
        scaffoldState = scaffoldState
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
                onNewValue = {
                    email = it
                    when {
                        it.isNotEmpty() -> inputIsNotValid = InputError(false, "")
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
                inputError = inputIsNotValid,
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
                onNewValue = {
                    password = it
                    when {
                        it.isNotEmpty() -> inputIsNotValid = InputError(false, "")
                    }
                },
                borderColor = cyan,
                labelText = "Password",
                textColor = Color.White,
                paddingValue = 8,
                keyboardType = KeyboardType.Password,
                inputPassword = isVisible,
                singleLine = true,
                placeholder = "Password",
                inputError = inputIsNotValid,
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
            LargeSolidButton(
                onClick = {
                    authViewModel.validateSignIn(email, password)
                    when (authViewModel.signInValid.value) {
                        true -> {
                            navController.popBackStack()
                            navController.navigate(Screens.HomeScreen.route)
                        }
                        else -> {
                            inputIsNotValid = InputError(true, "Please check the data")
                        }
                    }
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
