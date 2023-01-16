package com.example.jetpackcomposewalkthrough.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.constants.Constants
import com.example.jetpackcomposewalkthrough.data.HomeRepository
import com.example.jetpackcomposewalkthrough.ui.components.Icon
import com.example.jetpackcomposewalkthrough.ui.components.PainterIcon
import com.example.jetpackcomposewalkthrough.ui.theme.FigRed
import com.example.jetpackcomposewalkthrough.ui.theme.JetPackComposeWalkthroughTheme
import java.lang.Float.min

@Composable
fun DetailsScreen(
    itemId: Long,
    onBackClick: () -> Unit
) {
    val scrollState = rememberScrollState()
    Scaffold(
//        topBar = {
//            val item = HomeRepository.getHomeData().popularMenuItems.find { it.id == itemId }
//            TopAppBar(
//                title = { Text(text = item!!.name) },
//                navigationIcon = {
//                    IconButton(onClick = onBackClick) {
//                        Icon(Icons.Rounded.ArrowBack)
//                    }
//                }
//            )
//        }
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {

            val ( image, containerInfo ) = createRefs()

            Box(
                modifier = Modifier
                    .constrainAs(image){
                        linkTo(start = parent.start, end = parent.end)

                    }
                    .graphicsLayer {
                        alpha = min(1f, 1 - (scrollState.value / 600f))
                        translationY = -scrollState.value * 0.1f
                    }
            ){
                Image(
                    //painterResource(menuItem.image.removePrefix("drawable://").toInt()),
                    painterResource(R.drawable.burger_xpress_cover),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                )

                Surface(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(20.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                ){
                    Icon(
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
                        Icon(
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


            LazyColumn(
                modifier = Modifier
                    .constrainAs(containerInfo){
                        linkTo(start = parent.start, end = parent.end)
                        top.linkTo(image.bottom)
                    }
                    .fillMaxWidth()

            ) {
                item {

                    Surface(
//                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Red)

                    ) {

                        Image(
                            //painterResource(menuItem.image.removePrefix("drawable://").toInt()),
                            painterResource(R.drawable.foodi1),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(240.dp)
                                .fillMaxWidth()
                        )
                    }
                }

                item {

                    Surface(
//                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Red)

                    ) {

                        Image(
                            //painterResource(menuItem.image.removePrefix("drawable://").toInt()),
                            painterResource(R.drawable.foodi1),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(240.dp)
                                .fillMaxWidth()
                        )
                    }
                }

                item {

                    Surface(
//                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Red)

                    ) {

                        Image(
                            //painterResource(menuItem.image.removePrefix("drawable://").toInt()),
                            painterResource(R.drawable.foodi1),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(240.dp)
                                .fillMaxWidth()
                        )
                    }
                }

                item {

                    Surface(
//                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Red)

                    ) {

                        Image(
                            //painterResource(menuItem.image.removePrefix("drawable://").toInt()),
                            painterResource(R.drawable.foodi1),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(240.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }



    }
}


@Preview("HomeScreen")
@Composable
private fun CategoryScreenPreview() {
    JetPackComposeWalkthroughTheme {
        DetailsScreen(
            itemId = 4004,
            onBackClick = {}
        )
    }
}