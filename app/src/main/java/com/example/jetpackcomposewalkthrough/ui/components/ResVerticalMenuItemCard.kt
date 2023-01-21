package com.example.jetpackcomposewalkthrough.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.model.MenuItem
import com.example.jetpackcomposewalkthrough.model.ResturantDishDetails
import com.example.jetpackcomposewalkthrough.ui.theme.*

@Composable
fun ResVerticalMenuItemCard(
    menuItem: MenuItem,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(start = 16.dp, end = 16.dp)
            .clickable(onClick = onClick),

        shape = MaterialTheme.shapes.medium,
        backgroundColor = FigSecondaryBackground,
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
            ) {
                Row() {
                    Box(
                        modifier = Modifier
                            .width(140.dp)
                            .clip(RoundedCornerShape(16.dp)),
                    ) {

                        Image(
                            painterResource(menuItem.image.removePrefix("drawable://").toInt()),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                        )

                    }
                    Column {
                        Surface(
                            modifier = Modifier
                                .padding(start = 10.dp, top = 10.dp),

                            shape =  MaterialTheme.shapes.medium,
                            color = FigMatLightGreen
                        ){
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "${menuItem.discountRate}% OFF",
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.button,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(80.dp)
                                    .padding(top = 2.dp),

                                color = FigGreen
                            )
                        }

                        Box(
                            modifier = Modifier
                            .padding(start = 10.dp, top = 5.dp),
                        ){
                            Text(
                                text = menuItem.name,
                                style = MaterialTheme.typography.h6,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                color = FigPrimaryBlack
                            )
                        }

                        Box(
                            modifier = Modifier
                                .padding(start = 10.dp, top = 5.dp),
                        ){
                            Text(
                                text = "TK ${menuItem.price} ",
                                style = MaterialTheme.typography.body1,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                color = FigSecondaryBlack
                            )
                        }
                    }
                }
            }
            
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_add_circle_24),
                        modifier = Modifier
                            .size(50.dp)
                            .padding(5.dp),
                        tint = FigCrimson
                    )
                }

            }
        }

    }
}



@Preview("ResVerticalMenuItemCard")
@Composable
private fun ResVerticalMenuItemCard() {
    JetPackComposeWalkthroughTheme() {
        ResVerticalMenuItemCard(
            menuItem = MenuItem(
                id = 0,
                name = "Samosa",
                //description = "",
                image = "drawable://" + R.drawable.samosas,
                price = 10,
                categoryId = 0,
                categoryName = "Popular",
                rating = 4.19f,
                totalRaters = 12,
                deliveryDuration = "20 min",
                discountRate = 15,
                isFavourite = false,
                foodType = "Samosa",
            ),
            onClick = {}
        )
    }
}