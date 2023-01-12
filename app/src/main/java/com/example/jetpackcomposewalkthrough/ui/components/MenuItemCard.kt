package com.example.jetpackcomposewalkthrough.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.constants.Constants
import com.example.jetpackcomposewalkthrough.model.MenuItem
import com.example.jetpackcomposewalkthrough.ui.theme.*
import com.google.accompanist.coil.rememberCoilPainter
import kotlin.math.log


@Composable
fun MenuItemCard(
    menuItem: MenuItem,
    onClick: () -> Unit,
    type: String
) {
    println("image url: ${menuItem.image}")
    Card(
        modifier = when( type ) {
            Constants.TYPE_VERTICAL -> Modifier
                .height(280.dp)
                .padding(start = 20.dp, end = 20.dp)
                .clickable(onClick = onClick)

            else -> Modifier
                .width(320.dp)
                .height(230.dp)
                .clickable(onClick = onClick)
        },

        shape = MaterialTheme.shapes.medium,
        backgroundColor = Color.White,
    ) {
        //Row(modifier = Modifier.clickable(onClick = onClick)) {}
        ConstraintLayout(

        ) {

            val (name, image, ratingIcon ) = createRefs()

            Box(
               modifier = Modifier
                   .constrainAs(image) {
                       start.linkTo(parent.start)
                       end.linkTo(parent.end)
                       bottom.linkTo(name.top)
                   }
            ) {
//                NetworkImage(
//                    imageUrl = menuItem.image,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .height(140.dp).fillMaxWidth(),
//                    previewPlaceholder = R.drawable.foodi1
//                )
                Image(
                    painterResource(menuItem.image.removePrefix("drawable://").toInt()),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                     modifier = when( type ) {
                        Constants.TYPE_VERTICAL -> Modifier
                            .height(190.dp).fillMaxWidth()
                        else -> Modifier
                            .height(140.dp).fillMaxWidth()
                    }.clip(RoundedCornerShape(16.dp)),
                )

                Spacer(modifier = Modifier.width(16.dp))

                Surface(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(20.dp),

                   shape =  MaterialTheme.shapes.medium,
                   color = FigGreen
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

                        color = Color.White
                    )
                }


                Surface(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(20.dp)
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

                Surface(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(20.dp),

                    shape =  MaterialTheme.shapes.medium,
                    color = Color.White
                ){
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "${menuItem.deliveryDuration}",
                        style = MaterialTheme.typography.button,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(start = 10.dp, top = 2.dp, bottom = 2.dp, end = 10.dp),
                        color = FigRed
                    )
                }

            }

            Column(
                modifier = Modifier.constrainAs( name ) {
                    start.linkTo(parent.start, margin = 5.dp)
                    top.linkTo(image.bottom, margin = 5.dp)
                }
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
                    text = menuItem.categoryName,
                    style = MaterialTheme.typography.body2,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = FigHint
                )

                Spacer(modifier = Modifier.height(5.dp))
            }

            ///...........Price & Rating Row......../////
            Row(
                modifier = Modifier.constrainAs( ratingIcon ) {
                    start.linkTo(parent.start, margin = 5.dp)
                    top.linkTo(name.bottom)
                }.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Row(
                    modifier = Modifier
                ){
                    Text(
                        text = "৳",
                        style = MaterialTheme.typography.body2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = FigCrimson
                    )

                    Text(
                        text = "৳",
                        style = MaterialTheme.typography.body2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = FigCrimson
                    )

                    PainterIcon(
                        painter = painterResource(id = R.drawable.bicycle),
                        modifier = Modifier
                            .height(22.dp)
                            .width(22.dp)
                            .padding(start = 10.dp)
                    )

                    Text(
                        text = "Tk ${menuItem.price}",
                        style = MaterialTheme.typography.body2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }


                Row(
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    Icon(
                        Icons.Filled.Star,
                        tint = FigOrange,
                        modifier = Modifier.height(18.dp).width(18.dp)
                    )

                    Text(
                        text = menuItem.rating.toString(),
                        style = MaterialTheme.typography.body2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                    )

                    Text(
                        text = "(" +menuItem.totalRaters.toString()+ ")",
                        style = MaterialTheme.typography.body2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                    )
                }
            }

        }
    }
}

@Preview("Menu Item Card")
@Composable
private fun MenuItemCardPreview() {
    JetPackComposeWalkthroughTheme() {
        MenuItemCard(
            menuItem = MenuItem(
                id = 0,
                name = "Burger Express",
                description = "",
                image = "",
                price = 10,
                categoryId = 0,
                categoryName = "Fast-Food, Burger",
                rating = 4.19f,
                totalRaters = 12,
                deliveryDuration = "20 min",
                discountRate = 15,
                isFavourite = false,
            ),
            onClick = {},
            type = Constants.TYPE_HORIZONTAL
        )
    }
}