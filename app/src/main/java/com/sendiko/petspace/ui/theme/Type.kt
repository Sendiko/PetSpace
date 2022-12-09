package com.sendiko.petspace.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sendiko.petspace.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

fun textStyle(
    size: Int,
    color: Color,
    weight: FontWeight
): TextStyle {
    return TextStyle(
        fontSize = size.sp,
        color = color,
        fontWeight = weight,
        fontFamily = poppinsFamily
    )
}

val poppinsFamily = FontFamily(
    Font(R.font.poppins_thin, FontWeight.W100, FontStyle.Normal),
    Font(R.font.poppins_thinitalic, FontWeight.W100, FontStyle.Italic),
    Font(R.font.poppins_extralight, FontWeight.W200, FontStyle.Normal),
    Font(R.font.poppins_extralightitalic, FontWeight.W200, FontStyle.Italic),
    Font(R.font.poppins_light, FontWeight.W300, FontStyle.Normal),
    Font(R.font.poppins_lightitalic, FontWeight.W300, FontStyle.Italic),
    Font(R.font.poppins, FontWeight.W400, FontStyle.Normal),
    Font(R.font.poppins_italic, FontWeight.W400, FontStyle.Italic),
    Font(R.font.poppins_medium, FontWeight.W500, FontStyle.Normal),
    Font(R.font.poppins_mediumitalic, FontWeight.W500, FontStyle.Italic),
    Font(R.font.poppins_semibold, FontWeight.W600, FontStyle.Normal),
    Font(R.font.poppins_semibolditalic, FontWeight.W600, FontStyle.Italic),
    Font(R.font.poppins_bold, FontWeight.W700, FontStyle.Normal),
    Font(R.font.poppins_bolditalic, FontWeight.W700, FontStyle.Italic),
    Font(R.font.poppins_extrabold, FontWeight.W800, FontStyle.Normal),
    Font(R.font.poppins_extrabolditalic, FontWeight.W800, FontStyle.Italic),
    Font(R.font.poppins_black, FontWeight.W900, FontStyle.Normal),
    Font(R.font.poppins_blackitalic, FontWeight.W900, FontStyle.Italic),
)