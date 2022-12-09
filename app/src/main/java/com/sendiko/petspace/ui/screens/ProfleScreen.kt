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
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ){
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
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
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}