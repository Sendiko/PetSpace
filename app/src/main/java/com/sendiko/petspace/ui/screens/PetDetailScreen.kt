package com.sendiko.petspace.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sendiko.petspace.R
import com.sendiko.petspace.repository.viewmodel.PetViewModel
import com.sendiko.petspace.ui.component.*
import com.sendiko.petspace.ui.navigaton.Screens
import com.sendiko.petspace.ui.theme.cyan
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
            TopAppBarWithIcon(
                backgroundColor = darkBlue,
                icon = Icons.Filled.ArrowBack,
                iconTint = Color.White,
                title = "Details",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                    navController.navigate(Screens.HomeScreen.route)
                }
            )
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
            item {
                PetAddress(pet = pet)
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
                }
                Spacer(modifier = Modifier.padding(bottom = 16.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(horizontal = 16.dp)
                ){
                    item {
                        PetInfoBox(
                            pet = pet,
                            info = "Age"
                        )
                    }
                    item {
                        PetInfoBox(
                            pet = pet,
                            info = "Weight"
                        )
                    }
                    item {
                        PetInfoBox(
                            pet = pet,
                            info = "Color"
                        )
                    }
                }
            }
            item{
                Spacer(modifier = Modifier.padding(bottom = 16.dp))
                PetOwnerInfo(
                    backgroundColor = darkBlue,
                    ownerName = pet.previousOwner,
                    image = painterResource(id = R.drawable.profile_photo),
                    modifier = Modifier
                        .size(44.dp)
                        .padding(8.dp)
                )
            }
            item { 
                Spacer(modifier = Modifier.padding(bottom = 16.dp))
                LargeSolidButton(
                    onClick = { /*TODO*/ },
                    horizontalPaddingValues = 16,
                    verticalPaddingValues = 16,
                    buttonColors = cyan,
                    buttonText = "Adopt Me",
                    buttonTextColor = Color.White
                )
            }
        }
    }
}
