package com.sendiko.petspace.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sendiko.petspace.R
import com.sendiko.petspace.repository.model.Pet
import com.sendiko.petspace.ui.theme.blue
import com.sendiko.petspace.ui.theme.poppinsFamily
import com.sendiko.petspace.ui.theme.red

@Composable
fun PetCard(
    pet: Pet,
) {
    Card(
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
                            .padding(start = 8.dp),
                        text = pet.name,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 24.sp,
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

@Preview
@Composable
fun PetCardPrev() {
    PetCard(pet = Pet(
            "Hank",
            "Male",
        "Purwokerto, Banyumas",
            1,
            "Park Chaeyoung",
            R.drawable.hank
        ),
    )
}