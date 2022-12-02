package com.sendiko.petspace.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sendiko.petspace.R
import com.sendiko.petspace.repository.PetRepository
import com.sendiko.petspace.repository.viewmodel.PetViewModel
import com.sendiko.petspace.ui.component.PetCard
import com.sendiko.petspace.ui.component.TopAppBarWithSubtitle
import com.sendiko.petspace.ui.theme.darkBlue

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: PetViewModel
) {
    val petData = PetRepository().getAllPet()
    Scaffold(
        backgroundColor = darkBlue,
        topBar = {
            TopAppBarWithSubtitle(
                backgroundColor = darkBlue,
                title = "Hi, Sendiko!",
                subtitle = "Adopt new friend near you!",
                image = painterResource(id = R.drawable.profile_photo),
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { }
            )
        }
    ) {
        LazyColumn(
            Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(
                items = petData
            ){ pet ->
                PetCard(
                    pet = pet,
                    navController = navController,
                    viewModel = viewModel
                )
            }
        }
    }
}