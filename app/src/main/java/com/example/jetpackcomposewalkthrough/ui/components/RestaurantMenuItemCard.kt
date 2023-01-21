package com.example.jetpackcomposewalkthrough.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.constants.Constants
import com.example.jetpackcomposewalkthrough.model.MenuItem
import com.example.jetpackcomposewalkthrough.ui.theme.*

@Composable
fun RestaurantMenuItemCard(
    menuItem: MenuItem,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .width(280.dp)
            .height(220.dp)
            .clickable(onClick = onClick),

        shape = MaterialTheme.shapes.medium,
        backgroundColor = Color.White,
    ){
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {

            val (right, image,  left) = createRefs()

            Box(
                modifier = Modifier
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(right.top)
                    }
            ) {
                Image(
                    painterResource(menuItem.image.removePrefix("drawable://").toInt()),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp)),
                )

            }




            Row(
                modifier = Modifier.constrainAs( left ) {
                    start.linkTo(parent.start, margin = 10.dp)
                    top.linkTo(image.bottom, margin = 5.dp)
                }.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        text = menuItem.name,
                        style = MaterialTheme.typography.subtitle2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = FigBlack
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Tk ${menuItem.price}",
                        style = MaterialTheme.typography.body2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = FigHint
                    )

                    Spacer(modifier = Modifier.height(5.dp))
                }


                    IconButton(
                        onClick = {},
                        modifier = Modifier.padding(end = 20.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_add_circle_24),
                            modifier = Modifier
                                .size(40.dp)
                                .padding(5.dp),
                            tint = FigCrimson
                        )
                    }
                }



        }

    }
}




@Preview("RestaurantMenuItemCard")
@Composable
private fun RestaurantMenuItemCard() {
    JetPackComposeWalkthroughTheme() {
        RestaurantMenuItemCard(
            menuItem = MenuItem(
                id = 0,
                name = "Burger Express",
                //description = "",
                image = "drawable://" + R.drawable.pizza_burg,
                price = 10,
                categoryId = 0,
                categoryName = "Popular",
                rating = 4.19f,
                totalRaters = 12,
                deliveryDuration = "20 min",
                discountRate = 15,
                isFavourite = false,
            ),
            onClick = {}
        )
    }
}