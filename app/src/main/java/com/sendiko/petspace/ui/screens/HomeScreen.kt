package com.sendiko.petspace.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sendiko.petspace.repository.PetRepository
import com.sendiko.petspace.ui.component.PetCard
import com.sendiko.petspace.ui.theme.darkBlue

@Composable
fun HomeScreen(
    navController: NavHostController,
) {
    val petData = PetRepository().getAllPet()
    Scaffold(
        backgroundColor = darkBlue,
        topBar = {
            TopAppBar(
                backgroundColor = darkBlue,
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Hi, Sendiko!",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 24.sp
                        )
                    )
                    Text(
                        text = "Looking for soulmate?",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    )
                }
            }
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
                )
            }
        }
    }
}