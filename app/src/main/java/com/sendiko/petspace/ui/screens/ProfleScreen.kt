package com.sendiko.petspace.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sendiko.petspace.R
import com.sendiko.petspace.repository.OwnerRepo
import com.sendiko.petspace.ui.component.ProfileHeader
import com.sendiko.petspace.ui.theme.lightBlueAlternative
import com.sendiko.petspace.ui.theme.textStyle

@Composable
fun ProfileScreen(
//    navController: NavHostController
) {
    val ownerData = OwnerRepo().getOwnerInfo()
    Scaffold(
        backgroundColor = lightBlueAlternative,
        topBar = {
            ProfileHeader(
                backgroundColor = lightBlueAlternative,
                image = painterResource(id = R.drawable.profile_photo),
                modifier = Modifier,
                owner = ownerData
            )
        }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                Modifier
                    .padding(16.dp)
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Home",
                    style = textStyle(
                        size = 20,
                        color = Color.White,
                        weight = FontWeight.Medium
                    )
                )
                Text(
                    text = "Adoptable pets",
                    style = textStyle(
                        size = 20,
                        color = Color.White,
                        weight = FontWeight.Medium
                    )
                )
                Text(
                    text = "Chats",
                    style = textStyle(
                        size = 20,
                        color = Color.White,
                        weight = FontWeight.Medium
                    )
                )
                Text(
                    text = "Notifications",
                    style = textStyle(
                        size = 20,
                        color = Color.White,
                        weight = FontWeight.Medium
                    )
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp)
            ){
                Text(
                    text = "Settings",
                    style = textStyle(
                        size = 18,
                        color = Color.White,
                        weight = FontWeight.Medium
                    )
                )
                Text(
                    text = " | ",
                    style = textStyle(
                        size = 18,
                        color = Color.White,
                        weight = FontWeight.Medium
                    )
                )
                Text(
                    text = "Logout",
                    style = textStyle(
                        size = 18,
                        color = Color.White,
                        weight = FontWeight.Medium
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}