package com.example.jetpackcomposewalkthrough.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposewalkthrough.R

val Inter = FontFamily(
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_light, FontWeight.Light),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
)

val typography = Typography(
    h1 = TextStyle(
        fontFamily = Inter,
        fontSize = 96.sp,
        fontWeight = FontWeight.Bold,
    ),
    h2 = TextStyle(
        fontFamily = Inter,
        fontSize = 60.sp,
        fontWeight = FontWeight.Bold,
    ),
    h3 = TextStyle(
        fontFamily = Inter,
        fontSize = 48.sp,
        fontWeight = FontWeight.Bold,
    ),
    h4 = TextStyle(
        fontFamily = Inter,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
    ),
    h5 = TextStyle(
        fontFamily = Inter,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
    ),
    h6 = TextStyle(
        fontFamily = Inter,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
    ),
    subtitle1 = TextStyle(
        fontFamily = Inter,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
    ),
    subtitle2 = TextStyle(
        fontFamily = Inter,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
    ),
    body1 = TextStyle(
        fontFamily = Inter,
        fontSize = 16.sp,
        fontWeight = FontWeight.Light,
    ),
    body2 = TextStyle(
        fontFamily = Inter,
        fontSize = 14.sp,
        fontWeight = FontWeight.Light,
    ),
    button = TextStyle(
        fontFamily = Inter,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
    ),
    caption = TextStyle(
        fontFamily = Inter,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
    ),
    overline = TextStyle(
        fontFamily = Inter,
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
    )
)