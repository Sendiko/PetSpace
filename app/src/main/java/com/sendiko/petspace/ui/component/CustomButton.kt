package com.sendiko.petspace.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LargeSolidButton(
    onClick : () -> Unit,
    horizontalPaddingValues: Int,
    verticalPaddingValues: Int,
    buttonColors: Color,
    buttonText : String,
    buttonTextColor: Color
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPaddingValues.dp, vertical = verticalPaddingValues.dp)
            .height(64.dp),
        colors = ButtonDefaults.buttonColors(buttonColors)
    ) {
        Text(
            buttonText,
            style = TextStyle(
                fontSize = 18.sp,
                color = buttonTextColor
            )
        )
    }
}

@Composable
fun LargeOutlinedButton(
    onClick : (() -> Unit),
    horizontalPaddingValues: Int,
    verticalPaddingValues: Int,
    borderColor: Color,
    buttonColor: Color,
    buttonText : String,
    buttonTextColor: Color
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPaddingValues.dp, vertical = verticalPaddingValues.dp)
            .height(64.dp),
        border = BorderStroke(color = borderColor, width = 2.dp),
        colors = ButtonDefaults.buttonColors(buttonColor)
    ) {
        Text(
            buttonText,
            style = TextStyle(
                fontSize = 18.sp,
                color = buttonTextColor
            )
        )
    }
}