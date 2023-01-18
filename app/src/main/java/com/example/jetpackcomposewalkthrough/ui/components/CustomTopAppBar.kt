package com.example.jetpackcomposewalkthrough.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.ui.theme.FigRed
import com.example.jetpackcomposewalkthrough.ui.theme.JetPackComposeWalkthroughTheme
import androidx.compose.runtime.livedata.observeAsState
import com.example.jetpackcomposewalkthrough.ui.theme.FigBG1

@Composable
fun CustomTopAppBar(
    lazyListState: LazyListState,
    showWhiteAppBar: Boolean,
    onBackClick: () -> Unit
) {


    println("firstVisibleItemIndex123 ${lazyListState.firstVisibleItemIndex}")

    println("showWhiteAppBar123 $showWhiteAppBar")


    Box(
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth()
            .background(Color.Transparent)

    ) {
        AnimatedVisibility(
            visible = showWhiteAppBar
        ) {
            TopAppBar(
                title = {
                    Column() {
                        Text(
                            text = "Delivery",
                            modifier = Modifier,
                            style = MaterialTheme.typography.subtitle2
                        )
                        Text(
                            text = "15 min",
                            modifier = Modifier,
                            style = MaterialTheme.typography.subtitle2
                        )
                    }
                },
                elevation = 4.dp,
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = onBackClick ) {
                        com.example.jetpackcomposewalkthrough.ui.components.Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.arrowback),
                            modifier = Modifier
                                .size(25.dp)
                                .padding(5.dp),
                            tint = FigRed
                        )
                    }
                }
            )
        }

        AnimatedVisibility(
            visible = !showWhiteAppBar,
            enter = fadeIn(animationSpec = tween(300)),
            exit = fadeOut(animationSpec = tween(300))
        ) {
            Box(modifier = Modifier.fillMaxSize()){
                Surface(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(20.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                ){
                    com.example.jetpackcomposewalkthrough.ui.components.Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.arrowback),
                        modifier = Modifier
                            .size(25.dp)
                            .padding(5.dp),
                        tint = FigRed
                    )
                }

                Row(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 20.dp, end = 20.dp),
                ){
                    Surface(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White),
                    ){
                        com.example.jetpackcomposewalkthrough.ui.components.Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.shareicon),
                            modifier = Modifier
                                .size(25.dp)
                                .padding(5.dp),
                            tint = FigRed

                        )
                    }

                    Spacer(Modifier.width(5.dp))

                    Surface(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White),
                    ){
                        PainterIcon(
                            painter = painterResource(id = R.drawable.heart),
                            modifier = Modifier
                                .size(25.dp)
                                .padding(5.dp),
                            tint = FigRed

                        )
                    }
                }
            }
        }

    }
}



@Preview("TopAppBar")
@Composable
private fun TopAppBarPreview() {
    JetPackComposeWalkthroughTheme {
        CustomTopAppBar(
            rememberLazyListState(),
            showWhiteAppBar = false,
            {}
        )
    }
}
