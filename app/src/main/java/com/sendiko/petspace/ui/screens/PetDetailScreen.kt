package com.sendiko.petspace.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sendiko.petspace.repository.viewmodel.PetViewModel
import com.sendiko.petspace.ui.component.PetAdress
import com.sendiko.petspace.ui.component.PetImageHeader
import com.sendiko.petspace.ui.component.PetStory
import com.sendiko.petspace.ui.component.PetTitle
import com.sendiko.petspace.ui.navigaton.Screens
import com.sendiko.petspace.ui.theme.darkBlue
import com.sendiko.petspace.ui.theme.poppinsFamily

@Composable
fun PetDetailScreen(
    navController: NavHostController,
    viewModel: PetViewModel
) {
    val pet = viewModel.pet.value!!
    Scaffold(
        backgroundColor = darkBlue,
        topBar = {
            TopAppBar(
                backgroundColor = darkBlue,
                elevation = 0.dp,
                contentPadding = PaddingValues(horizontal = 16.dp),
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "arrow back",
                    modifier = Modifier.clickable { navController.navigate(Screens.HomeScreen.route) },
                    tint = Color.White
                )
                Spacer(modifier = Modifier.padding(end = 8.dp))
                Text(
                    text = "Detail",
                    style = TextStyle(
                        fontSize = 22.sp,
                        color = Color.White,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.SemiBold,
                    )
                )
            }
        }
    ) {
        LazyColumn {
            item {
                PetImageHeader(pet = pet)
            }
            item {
                Spacer(modifier = Modifier.padding(top = 32.dp))
            }
            item {
                PetTitle(pet = pet)
            }
            item{
                PetAdress(pet = pet)
            }
            item {
                PetStory(pet = pet)
            }
            item {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.padding(bottom = 32.dp))
                    Text(
                        text = "Pet Info",
                        style = TextStyle(
                            color = Color.White,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp
                        )
                    )
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ){

                    }
                }
            }
        }
    }
}
