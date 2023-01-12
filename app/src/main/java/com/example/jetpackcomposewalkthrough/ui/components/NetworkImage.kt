package com.example.jetpackcomposewalkthrough.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposewalkthrough.R
import com.google.accompanist.coil.rememberCoilPainter


@Composable
fun NetworkImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    fadeIn: Boolean = true,
    @DrawableRes previewPlaceholder: Int = 0
) {
//    Image(
//        painter = rememberCoilPainter(
//            imageUrl,
//            fadeIn = fadeIn,
//            previewPlaceholder = previewPlaceholder
//        ),
//        contentDescription = null,
//        modifier = modifier,
//        contentScale = contentScale,
//        alignment = Alignment.Center,
//    )

//    Image(
//        painterResource(R.drawable.trending2),
//        contentDescription = "",
//        contentScale = contentScale,
//        modifier = Modifier
//
//    )
}