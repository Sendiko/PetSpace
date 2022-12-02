package com.sendiko.petspace.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sendiko.petspace.R
import com.sendiko.petspace.repository.PetRepository
import com.sendiko.petspace.repository.viewmodel.PetViewModel
import com.sendiko.petspace.ui.component.PetCard
import com.sendiko.petspace.ui.theme.darkBlue
import com.sendiko.petspace.ui.theme.poppinsFamily

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: PetViewModel
) {
    val petData = PetRepository().getAllPet()
    Scaffold(
        backgroundColor = darkBlue,
        topBar = {
            TopAppBar(
                backgroundColor = darkBlue,
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Hi, Sendiko!",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 20.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.SemiBold,
                            )
                        )
                        Text(
                            text = "Adopt a new friend near you!",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 14.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Normal,
                            )
                        )
                    }
                    Image(
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Fit,
                        painter = painterResource(id = R.drawable.profile_photo),
                        contentDescription = "Image Header",
                        modifier = Modifier
                            .size(48.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {  },
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
                    navController = navController,
                    viewModel = viewModel
                )
            }
        }
    }
}