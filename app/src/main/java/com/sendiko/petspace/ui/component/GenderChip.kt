package com.sendiko.petspace.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sendiko.petspace.ui.theme.blueAlternative
import com.sendiko.petspace.ui.theme.cyan

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
            color = cyan,
            fontSize = 14.sp
        )
    }
}

@Preview
@Composable
fun GenderChipPreview() {
    GenderChip(gender = "Male")
}