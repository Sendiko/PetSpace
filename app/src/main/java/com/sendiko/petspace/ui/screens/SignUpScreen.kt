package com.sendiko.petspace.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sendiko.petspace.repository.UserOptions
import com.sendiko.petspace.repository.viewmodel.AuthViewModel
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Username",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                    )
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    value = username,
                    onValueChange = {
                        username = it
                        when{
                            it.isNotEmpty() -> inputIsNotValid = false
                        }
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = cyan,
                        focusedBorderColor = cyan
                    ),
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    singleLine = true,
                    placeholder = { Text("Username") },
                    isError = inputIsNotValid
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Email",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                    )
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    value = email,
                    onValueChange = {
                        email = it
                        when{
                            it.isNotEmpty() -> inputIsNotValid = false
                        }
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = cyan,
                        focusedBorderColor = cyan
                    ),
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    singleLine = true,
                    placeholder = { Text("Email") },
                    isError = inputIsNotValid
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Password",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                    )
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    value = password,
                    onValueChange = {
                        password = it
                        when{
                            it.isNotEmpty() -> inputIsNotValid = false
                        }
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = cyan,
                        focusedBorderColor = cyan
                    ),
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    singleLine = true,
                    placeholder = { Text("Password") },
                    visualTransformation = when (isVisible) {
                        false -> VisualTransformation.None
                        else -> PasswordVisualTransformation()
                    },
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
                    isError = inputIsNotValid
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Select User/Shelter",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                    )
                )
                ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {
                    expanded = !expanded
                }) {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        value = user,
                        onValueChange = {
                            user = it
                            when{
                                it.isNotEmpty() -> inputIsNotValid = false
                            }
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = cyan,
                            focusedBorderColor = cyan
                        ),
                        textStyle = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Normal,
                        ),
                        singleLine = true,
                        placeholder = { Text("User/Shelter") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        },
                        isError = inputIsNotValid
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
            }
            when(inputIsNotValid){
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
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
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
                    when (authViewModel.valid.value) {
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