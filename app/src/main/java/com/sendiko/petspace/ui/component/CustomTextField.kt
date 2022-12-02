package com.sendiko.petspace.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sendiko.petspace.ui.theme.poppinsFamily

@Composable
fun CustomTextField(
    textValue: String,
    borderColor: Color,
    labelText: String,
    textColor: Color,
    paddingValue : Int,
    keyboardType: KeyboardType,
    inputPassword : Boolean,
    singleLine : Boolean
) {
    var value by remember {
        mutableStateOf(textValue)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = paddingValue.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = labelText,
            style = TextStyle(
                color = textColor,
                fontSize = 20.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal,
            )
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = paddingValue.dp),
            value = value,
            onValueChange = {
                value = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = borderColor,
                focusedBorderColor = borderColor
            ),
            textStyle = TextStyle(
                color = textColor,
                fontSize = 18.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            visualTransformation = when(inputPassword){
                true -> PasswordVisualTransformation()
                else -> VisualTransformation.None
            },
            singleLine = singleLine
        )
    }
}