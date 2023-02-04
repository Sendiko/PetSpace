package com.sendiko.petspace.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.*
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
import com.sendiko.petspace.repository.UserOptions
import com.sendiko.petspace.repository.viewmodel.AuthViewModel
import com.sendiko.petspace.ui.component.CustomTextField
import com.sendiko.petspace.ui.component.LargeSolidButton
import com.sendiko.petspace.ui.component.RegularTopAppBar
import com.sendiko.petspace.ui.navigaton.Screens
import com.sendiko.petspace.ui.theme.cyan
import com.sendiko.petspace.ui.theme.darkBlue
import com.sendiko.petspace.ui.theme.poppinsFamily

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SignUpScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var user by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val userOptions = listOf(UserOptions.User.option, UserOptions.Shelter.option)
    var isVisible by remember { mutableStateOf(true) }
    var inputIsNotValid by remember { mutableStateOf(false) }

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
            CustomTextField(
                textValue = username,
                onNewValue = {
                    username = it
                    when {
                        it.isNotEmpty() -> inputIsNotValid = false
                    }
                },
                borderColor = cyan,
                labelText = "Username",
                textColor = Color.White,
                paddingValue = 8,
                keyboardType = KeyboardType.Text,
                inputPassword = false,
                singleLine = true,
                isError = inputIsNotValid,
                placeholder = "Username",
                trailingIcon = { },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Person,
                        contentDescription = null
                    )
                }
            )
            CustomTextField(
                textValue = email,
                onNewValue = {
                    email = it
                    when {
                        it.isNotEmpty() -> inputIsNotValid = false
                    }
                },
                borderColor = cyan,
                labelText = "Email",
                textColor = Color.White,
                paddingValue = 8,
                keyboardType = KeyboardType.Email,
                inputPassword = false,
                singleLine = true,
                isError = inputIsNotValid,
                placeholder = "Email",
                trailingIcon = { },
                leadingIcon = { Icon(imageVector = Icons.Rounded.Email, contentDescription = null) }
            )
            CustomTextField(
                textValue = password,
                onNewValue = {
                    password = it
                    when {
                        it.isNotEmpty() -> inputIsNotValid = false
                    }
                },
                borderColor = cyan,
                labelText = "Password",
                textColor = Color.White,
                paddingValue = 8,
                keyboardType = KeyboardType.Password,
                inputPassword = isVisible,
                singleLine = true,
                isError = inputIsNotValid,
                placeholder = "Password",
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
            ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {
                expanded = !expanded
            }) {
                CustomTextField(
                    textValue = user,
                    onNewValue = {
                        user = it
                        when {
                            it.isNotEmpty() -> inputIsNotValid = false
                        }
                    },
                    borderColor = cyan,
                    labelText = "Select User/Shelter",
                    textColor = Color.White,
                    paddingValue = 7,
                    keyboardType = KeyboardType.Text,
                    inputPassword = false,
                    singleLine = true,
                    isError = inputIsNotValid,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    leadingIcon = {
                        when (user) {
                            UserOptions.User.option -> Icon(
                                imageVector = Icons.Rounded.Person,
                                contentDescription = null
                            )
                            UserOptions.Shelter.option -> Icon(
                                imageVector = Icons.Rounded.NightShelter,
                                contentDescription = null
                            )
                            else -> Icon(
                                imageVector = Icons.Rounded.PersonAdd,
                                contentDescription = null
                            )
                        }
                    },
                    placeholder = "User/Shelter"
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    userOptions.forEach {
                        DropdownMenuItem(onClick = {
                            user = it
                            expanded = false
                            inputIsNotValid = false
                        }) {
                            Text(it)
                        }
                    }
                }
            }
            when (inputIsNotValid) {
                true -> "Please check the data"
                else -> null
            }?.let { it1 ->
                Text(
                    text = it1,
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
                    authViewModel.validateSignUp(
                        username,
                        email,
                        password,
                        user
                    )
                    when (authViewModel.signUpValid.value) {
                        true -> {
                            navController.popBackStack()
                            navController.navigate(Screens.SignInScreen.route)
                        }
                        else -> inputIsNotValid = true
                    }
                },
                horizontalPaddingValues = 0,
                verticalPaddingValues = 32,
                buttonColors = cyan,
                buttonText = "Sign Up",
                buttonTextColor = Color.White
            )
            Text(text = "Already have account? Sign in here",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    textDecoration = TextDecoration.Underline
                ),
                modifier = Modifier.clickable {
                    navController.popBackStack()
                    navController.navigate(Screens.SignInScreen.route)
                }
            )
        }
    }
}