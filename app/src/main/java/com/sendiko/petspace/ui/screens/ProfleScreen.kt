package com.sendiko.petspace.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sendiko.petspace.R
import com.sendiko.petspace.repository.OwnerRepo
import com.sendiko.petspace.ui.component.ProfileHeader
import com.sendiko.petspace.ui.theme.darkBlue

@Composable
fun ProfileScreen(
    navController: NavHostController
) {
    val ownerData = OwnerRepo().getOwnerInfo()
    Scaffold(
        backgroundColor = darkBlue,
        topBar = {
            ProfileHeader(
                backgroundColor = darkBlue,
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
                Modifier.padding(start = 16.dp),
               verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start
            ) {

            }
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.End
            ) {

            }
        }
    }
}