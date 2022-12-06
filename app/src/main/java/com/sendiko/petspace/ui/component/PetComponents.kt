package com.sendiko.petspace.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sendiko.petspace.R
import com.sendiko.petspace.repository.model.Pet
import com.sendiko.petspace.repository.viewmodel.PetViewModel
import com.sendiko.petspace.ui.navigaton.Screens
import com.sendiko.petspace.ui.theme.*

@Composable
fun PetImageHeader(
    pet : Pet
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth,
            painter = painterResource(pet.pictures),
            contentDescription = "Image Header"
        )
    }
}

@Composable
fun PetCard(
    pet: Pet,
    navController: NavHostController,
    viewModel: PetViewModel
) {
    Card(
        modifier = Modifier.clickable {
            navController.navigate(Screens.PetDetailScreen.route)
            viewModel.savePet(pet)
        },
        shape = MaterialTheme.shapes.small,
        elevation = 8.dp,
        backgroundColor = blue
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                alignment = Alignment.Center,
                contentScale = ContentScale.Fit,
                painter = painterResource(pet.pictures),
                contentDescription = "Image Header",
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp)),
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = 16.dp),
                        text = pet.name,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    GenderChip(gender = pet.gender)
                }
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                    Icon(
                        Icons.Filled.LocationOn,
                        contentDescription = null,
                        tint = red
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = pet.address,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 12.sp,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Light
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun GenderChip(
    gender : String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(4.dp)
            .background(
                color = blueAlternative,
                shape = RoundedCornerShape(32.dp)
            )
    ){
        Text(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal =  16.dp),
            text = gender,
            style = TextStyle(
                color = cyan,
                fontSize = 14.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Light
            )
        )
    }
}

@Composable
fun PetTitle(
    pet: Pet
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(48.dp)
    ) {
        Text(
            text = pet.name,
            style = TextStyle(
                color = Color.White,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp
            )
        )
        GenderChip(gender = pet.gender)
    }
}

@Composable
fun PetAddress(
    pet: Pet
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Icon(
            Icons.Filled.LocationOn,
            contentDescription = null,
            tint = red
        )
        Spacer(modifier = Modifier.padding(end = 4.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = pet.address,
            style = TextStyle(
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Light
            )
        )
    }
}

@Composable
fun PetStory(
    pet: Pet
) {
    Column(
        Modifier.padding(16.dp)
    ) {
        Spacer(modifier = Modifier.padding(bottom = 64.dp))
        Text(
            text = "My Story",
            style = TextStyle(
                color = Color.White,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
        )
        Spacer(modifier = Modifier.padding(bottom = 16.dp))
        Text(
            text = pet.story,
            style = TextStyle(
                color = Color.White,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify
            )
        )
    }
}

@Composable
fun PetInfoBox(
    pet: Pet,
    info : String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(
                color = blue,
                shape = RoundedCornerShape(8.dp)
            )
            .height(96.dp)
            .width(128.dp)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text =
                when(info){
                    "Age" -> "${pet.age} years"
                    "Weight" -> "${pet.weight} Kg"
                    "Color" -> pet.color
                    else -> {"null"}
                },
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            )
            Text(
                text = info,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}

@Composable
fun PetOwnerInfo(
    backgroundColor: Color,
    ownerName : String,
    image : Painter,
    modifier: Modifier
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .background(backgroundColor)
    ) {
        Text(
            text = "Owner Info",
            style = TextStyle(
                color = Color.White,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.wrapContentWidth()
            ) {
                Image(
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Fit,
                    painter = image,
                    contentDescription = "Image Header",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(8.dp)),
                )
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = ownerName,
                        style = TextStyle(
                            color = Color.White,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp
                        )
                    )
                    Text(
                        text = "Pet Lover",
                        style = TextStyle(
                            color = Color.White,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp
                        )
                    )
                }
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(
                        cyan,
                        shape = RoundedCornerShape(48.dp)
                    )
            ){
                Icon(
                    Icons.Filled.Email,
                    contentDescription = null,
                    modifier = modifier,
                    tint = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun PetComponentsPrev() {
    PetOwnerInfo(
        backgroundColor = darkBlue,
        ownerName = "Jennie Kim",
        image = painterResource(id = R.drawable.profile_photo),
        modifier = Modifier
            .size(44.dp)
            .padding(8.dp)
    )
}