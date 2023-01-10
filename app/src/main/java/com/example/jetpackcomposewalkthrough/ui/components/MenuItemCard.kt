package com.example.jetpackcomposewalkthrough.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.model.MenuItem
import com.example.jetpackcomposewalkthrough.ui.theme.FigYellow
import com.example.jetpackcomposewalkthrough.ui.theme.JetPackComposeWalkthroughTheme
import kotlin.math.log


@Composable
fun MenuItemCard(
    menuItem: MenuItem,
    onClick: () -> Unit
) {
//    Surface(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(220.dp),
//        color = MaterialTheme.colors.background,
//        contentColor = MaterialTheme.colors.onSurface,
//
//    ) {
//        ConstraintLayout(
//            modifier = Modifier.fillMaxSize()
//        ) {
//            val (card, name, price, image) = createRefs()
//        }
//
//    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = Color.White,
    ) {
        //Row(modifier = Modifier.clickable(onClick = onClick)) {}
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {

            val (name, price, image, rating,
                totalRaters, categoryName, deliveryDuration,
                discount, favouriteIcon, ratingIcon ) = createRefs()

            Box(
               modifier = Modifier
                   .constrainAs(image) {
                       start.linkTo(parent.start)
                       end.linkTo(parent.end)
                       bottom.linkTo(name.top)
                   }
            ) {
                NetworkImage(
                    imageUrl = menuItem.image,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(300.dp)
                        .height(140.dp),

                    previewPlaceholder = R.drawable.foodi5
                )

                Spacer(modifier = Modifier.width(16.dp))

                Surface(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .width(70.dp)
                        .padding(20.dp),
                    
                   shape =  MaterialTheme.shapes.small,
                   color = Color.Yellow
                ){
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "${menuItem.discountRate}% discount",
                        style = MaterialTheme.typography.overline,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

            }

            Text(
                text = menuItem.name,
                style = MaterialTheme.typography.subtitle2,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.constrainAs( name ) {
                    start.linkTo(parent.start, margin = 5.dp)
                    end.linkTo(ratingIcon.start)
                    top.linkTo(image.bottom, margin = 5.dp)

                    height = Dimension.wrapContent
                }.width(150.dp)
            )

            Icon(
                Icons.Filled.Star,
                tint = FigYellow,
                modifier = Modifier.constrainAs( ratingIcon ) {
                    start.linkTo(name.end, margin = 15.dp)
                    end.linkTo(rating.start)
                    top.linkTo(image.bottom, margin = 4.dp)

                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }
            )

            Text(
                text = menuItem.rating.toString(),
                style = MaterialTheme.typography.body2,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.constrainAs( rating ) {
                    start.linkTo(ratingIcon.end)
                    end.linkTo(totalRaters.start)
                    top.linkTo(image.bottom, margin = 5.dp)

                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }
            )

            Text(
                text = "(" +menuItem.totalRaters.toString()+ ")",
                style = MaterialTheme.typography.body2,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.constrainAs( totalRaters ) {
                    start.linkTo(rating.end, margin = 2.dp)
                    end.linkTo(parent.end, margin = 2.dp)
                    top.linkTo(image.bottom, margin = 5.dp)

                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }
            )

            Text(
                text = menuItem.categoryName,
                style = MaterialTheme.typography.body2,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.constrainAs( categoryName ) {
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(totalRaters.end)
                    top.linkTo(name.bottom, margin = 5.dp)

                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }
            )

            Text(
                text = "Tk ${menuItem.price}",
                style = MaterialTheme.typography.body2,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.constrainAs( price ) {
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(totalRaters.end)
                    top.linkTo(categoryName.bottom, margin = 5.dp)

                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }
            )

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
            onClick = {}
        )
    }
}