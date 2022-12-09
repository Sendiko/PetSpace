package com.sendiko.petspace.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sendiko.petspace.R
import com.sendiko.petspace.ui.theme.lightBlueAlternative
import com.sendiko.petspace.ui.theme.textStyle

@Composable
fun ChatItem(
    backgroundColor: Color,
    image : Painter,
    textPerson : String,
    textMessage : String,
    textDate : String,
    modifier: Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Image(
                alignment = Alignment.Center,
                contentScale = ContentScale.Fit,
                painter = image,
                contentDescription = "Image Header",
                modifier = modifier,
            )
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = textPerson,
                    style = textStyle(
                        size = 18,
                        weight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                Text(
                    text = textMessage,
                    style = textStyle(
                        size = 14,
                        weight = FontWeight.Normal,
                        color = Color.White
                    )
                )
            }
        }
        Text(
            text = textDate,
            style = textStyle(
                size = 12,
                color = Color.White,
                weight = FontWeight.Light
            ),
            modifier = Modifier.padding(end = 8.dp)
        )
    }
}

@Preview
@Composable
fun ChatItemPrev() {
    ChatItem(
        backgroundColor = lightBlueAlternative,
        image = painterResource(id = R.drawable.profile_photo),
        modifier = Modifier.size(64.dp),
        textPerson = "Jokopi",
        textMessage = "Ingfo banteng",
        textDate = "11/03/1998"
    )
}