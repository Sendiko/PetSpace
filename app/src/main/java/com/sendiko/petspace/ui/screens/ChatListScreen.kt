package com.sendiko.petspace.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sendiko.petspace.repository.ChatListrepo
import com.sendiko.petspace.ui.component.ChatItem
import com.sendiko.petspace.ui.component.TopAppBarWithIcon
import com.sendiko.petspace.ui.navigaton.Screens
import com.sendiko.petspace.ui.theme.lightBlueAlternative

@Composable
fun ChatListScreen(
    navController: NavHostController
) {
    val searchChat by remember {
        mutableStateOf("")
    }
    val chatList = ChatListrepo().getChatList()
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
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                item {
                    Spacer(modifier = Modifier.padding(bottom = 16.dp))
                }
                items(
                    items = chatList
                ){ chatList ->
                    ChatItem(
                        backgroundColor = lightBlueAlternative,
                        image = painterResource(id = chatList.image),
                        textPerson = chatList.textPerson,
                        textMessage = chatList.textMessage,
                        textDate = chatList.textDate,
                        modifier = Modifier.size(54.dp)
                    )
                }
            }
        }
    }
}