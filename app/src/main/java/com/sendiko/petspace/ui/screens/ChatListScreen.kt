package com.sendiko.petspace.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sendiko.petspace.ui.component.CustomSolidTextField
import com.sendiko.petspace.ui.component.TopAppBarWithIcon
import com.sendiko.petspace.ui.navigaton.Screens
import com.sendiko.petspace.ui.theme.blue
import com.sendiko.petspace.ui.theme.lightBlue
import com.sendiko.petspace.ui.theme.lightBlueAlternative

@Composable
fun ChatListScreen(
    navController: NavHostController
) {
    val searchChat by remember {
        mutableStateOf("")
    }
    
    Scaffold(
        topBar = {
                 TopAppBarWithIcon(
                     backgroundColor = lightBlueAlternative,
                     icon = Icons.Default.ArrowBack,
                     modifier = Modifier.clickable {
                        navController.navigate(Screens.ProfileScreen.route)
                     },
                     iconTint = Color.White,
                     title = "Chats"
                 )
        },
        backgroundColor = lightBlueAlternative,
    ) {
        Column(
            Modifier.padding(horizontal = 16.dp)
        ) {
            CustomSolidTextField(
                textValue = searchChat,
                labelText = null,
                textColor = blue,
                paddingValue = 0,
                backgroundColor = Color.White,
                keyboardType = KeyboardType.Text,
                inputPassword = false,
                singleLine = true,
                trailingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        tint = lightBlue
                    )
                },
            )
            LazyColumn(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                
            }
        }
    }
}