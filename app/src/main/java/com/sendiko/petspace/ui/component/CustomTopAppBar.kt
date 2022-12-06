package com.sendiko.petspace.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sendiko.petspace.repository.model.Owner
import com.sendiko.petspace.ui.theme.poppinsFamily

@Composable
fun RegularTopAppBar(
    backgroundColor: Color,
    title : String
) {
    TopAppBar(
        backgroundColor = backgroundColor,
        elevation = 0.dp,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 24.sp,
                color = Color.White,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Bold,
            )
        )
    }
}

@Composable
fun TopAppBarWithIcon(
    backgroundColor: Color,
    icon: ImageVector,
    modifier: Modifier,
    iconTint: Color,
    title: String
) {
    TopAppBar(
        backgroundColor = backgroundColor,
        elevation = 0.dp,
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        Icon(
            icon,
            contentDescription = "arrow back",
            modifier = modifier,
            tint = iconTint
        )
        Spacer(modifier = Modifier.padding(end = 8.dp))
        Text(
            text = title,
            style = TextStyle(
                fontSize = 22.sp,
                color = Color.White,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
            )
        )
    }
}

@Composable
fun TopAppBarWithSubtitle(
    backgroundColor: Color,
    title: String,
    subtitle : String,
    image : Painter,
    modifier: Modifier
) {
    TopAppBar(
        backgroundColor = backgroundColor,
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
                    text = title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.SemiBold,
                    )
                )
                Text(
                    text = subtitle,
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
                painter = image,
                contentDescription = "Image Header",
                modifier = modifier,
            )
        }
    }
}

@Composable
fun ProfileHeader(
    backgroundColor: Color,
    image: Painter,
    modifier: Modifier,
    owner: Owner
) {
    TopAppBar(
        contentPadding = PaddingValues(16.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp
    ) {
        Image(
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit,
            painter = image,
            contentDescription = "Image Header",
            modifier = modifier.size(72.dp),
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = owner.name,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFamily
                )
            )
            Text(
                text = owner.address,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = poppinsFamily
                )
            )
        }
    }
}