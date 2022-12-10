package com.sendiko.petspace.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sendiko.petspace.ui.theme.blueAlternative
import com.sendiko.petspace.ui.theme.cyan
import com.sendiko.petspace.ui.theme.poppinsFamily

@Composable
fun CustomOutlinedTextField(
    textValue: String,
    borderColor: Color,
    labelText: String?,
    textColor: Color,
    paddingValue: Int,
    keyboardType: KeyboardType,
    inputPassword: Boolean,
    singleLine: Boolean
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
        if (labelText != null) {
            Text(
                text = labelText,
                style = TextStyle(
                    color = textColor,
                    fontSize = 20.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                )
            )
        } else {
            Spacer(modifier = Modifier)
        }
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

@Composable
fun CustomSolidTextField(
    textValue: String,
    labelText: String?,
    textColor: Color,
    paddingValue: Int,
    trailingIcon : @Composable (() -> Unit),
    backgroundColor: Color,
    keyboardType: KeyboardType,
    inputPassword: Boolean,
    singleLine: Boolean
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
        if (labelText != null) {
            Text(
                text = labelText,
                style = TextStyle(
                    color = textColor,
                    fontSize = 20.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                )
            )
        } else {
            Spacer(modifier = Modifier)
        }
        TextField(
            value = value,
            onValueChange = {
                value = it
            },
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = backgroundColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            trailingIcon = trailingIcon,
            modifier = Modifier.fillMaxWidth(),
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
            singleLine = singleLine,
        )
    }
}

@Preview
@Composable
fun TextFieldPreview() {
    val searchChat by remember {
        mutableStateOf("")
    }
    CustomSolidTextField(
        textValue = searchChat,
        labelText = null,
        textColor = Color.White,
        paddingValue = 0,
        backgroundColor = blueAlternative,
        keyboardType = KeyboardType.Text,
        inputPassword = false,
        singleLine = true,
        trailingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                tint = cyan
            )
        },
    )
}