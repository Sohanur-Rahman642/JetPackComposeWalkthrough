package com.example.jetpackcomposewalkthrough.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.model.MenuItem
import com.example.jetpackcomposewalkthrough.model.ResturantDishDetails
import com.example.jetpackcomposewalkthrough.ui.theme.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun BottomSheetContent(menuItem: MenuItem) {

    val itemsListState = rememberLazyListState()
    var text by rememberSaveable { mutableStateOf("") }
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(menuItem.selections?.get(0)) }

    LazyColumn(
        state = itemsListState,
        modifier = Modifier

    ){
        item {
            Box(
                modifier = Modifier
                    .fillParentMaxWidth()

            ) {
                Image(
                    painterResource(menuItem.image.removePrefix("drawable://").toInt()),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                )

            }
        }

        item {
            Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 5.dp)) {
                Text(
                    text = menuItem.name,
                    style = MaterialTheme.typography.h6,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = FigPrimaryBlack
                )

                Text(
                    text = "Single 7 inch/ Couple 10 inch/ Friends 12 inch",
                    style = MaterialTheme.typography.subtitle2,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = FigSecondaryBlack
                )
            }
        }

        item {
            Surface(
                modifier = Modifier
                    .height(80.dp)
                    .padding(10.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                color = FigSecondaryBackground
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),

                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Surface(
                        modifier = Modifier
                            .padding(10.dp)
                            .width(140.dp),

                        shape = RoundedCornerShape(8.dp),
                        color = Color.White

                    ) {
                        Row(  modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),

                            horizontalArrangement = Arrangement.SpaceEvenly
                        ){
                            IconButton(
                                onClick = {},
                                modifier = Modifier
                            ) {
                                PainterIcon(
                                    painter = painterResource(id = R.drawable.minus),
                                    modifier = Modifier
                                        .size(32.dp)
                                        .padding(5.dp),
                                    tint = FigBlack
                                )
                            }

                            Surface(
                                modifier = Modifier
                                    .wrapContentSize(),
                                color = FigSecondaryBabyPink,
                                shape = RoundedCornerShape(4.dp)

                            ) {
                                Text(
                                    text = "1",
                                    style = MaterialTheme.typography.button,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = FigSecondaryBlack,
                                    modifier = Modifier
                                        .padding(
                                            start = 10.dp,
                                            top = 5.dp,
                                            bottom = 5.dp,
                                            end = 10.dp
                                        )
                                        .clip(RoundedCornerShape(16.dp)),
                                    textAlign = TextAlign.Center
                                )
                            }


                            IconButton(
                                onClick = {},
                                modifier = Modifier
                            ) {
                                PainterIcon(
                                    painter = painterResource(id = R.drawable.plus),
                                    modifier = Modifier
                                        .size(32.dp)
                                        .padding(5.dp),
                                    tint = FigCrimson
                                )
                            }
                        }

                    }

                    Surface(
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Row(  modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically

                        ){
                            Text(
                                text = "৳",
                                style = MaterialTheme.typography.h5,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                color = FigCrimson,
                             

                            )
                            
                            Spacer(modifier = Modifier.width(2.dp))

                            Text(
                                text = menuItem.price.toString(),
                                style = MaterialTheme.typography.h5,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                color = FigPrimaryBlack,
                               
                            )
                        }

                    }
                }
            }
        }

        item {
            Column(modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 5.dp)
                .fillMaxWidth()) {
                menuItem.selections?.let {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Column() {
                            Text(
                                text ="Select your ${menuItem.foodType} size",
                                style = MaterialTheme.typography.h6,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                color = FigPrimaryBlack,
                            )
                            Text(
                                text ="Please select 1",
                                style = MaterialTheme.typography.body2,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                color = FigHint,
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.Center
                        ) {
                            Surface(
                                modifier = Modifier
                                    .wrapContentSize(),
                                shape = RoundedCornerShape(12.dp),
                                color = FigUltraLightBabyPink
                            ) {
                                Text(
                                    text ="Required",
                                    style = MaterialTheme.typography.body2,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = FigCrimson,
                                    modifier = Modifier.padding(5.dp)
                                )
                            }
                        }
                    }

                    menuItem.selections?.forEach { pair ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = (pair == selectedOption),
                                    onClick = {
                                        onOptionSelected(
                                            pair
                                        )
                                    }

                                ),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Row(
                                modifier = Modifier,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = (pair == selectedOption),modifier = Modifier.padding(all = Dp(value = 8F)),
                                    onClick = {
                                        onOptionSelected(pair)
                                    },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = FigCrimson,
                                        unselectedColor = FigPrimaryOptionColor
                                    )
                                )

                                Text(
                                    text = pair.first,
                                    style = MaterialTheme.typography.body2,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = FigPrimaryOptionColor,
                                    textAlign = TextAlign.Center,
                                )
                            }

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.End
                            ) {
                                Text(
                                    text = "৳",
                                    style = MaterialTheme.typography.subtitle2,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = FigCrimson,
                                    textAlign = TextAlign.Center,
                                )

                                Text(
                                    text = pair.second.toString(),
                                    style = MaterialTheme.typography.button,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = FigPrimaryBlack,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(start = 2.dp, end = 10.dp)
                                )
                            }
                        }

                    }
                }

                Text(
                    text = "Additional Information",
                    style = MaterialTheme.typography.h6,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = FigPrimaryBlack,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )

                Text(
                    text = "Please let us know if you are allergic to anything if we need to avoid anything",
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = FigSecondaryContentColor,
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, top = 5.dp)
                        .fillMaxWidth()
                )

                Surface(
                    modifier = Modifier
                        .height(100.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 5.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    border = BorderStroke(1.dp, FigPrimarySurfaceColor),
                    color = FigSecondarySurfaceColor
                ){
                    TextField(
                        value = text,
                        maxLines = 10,
                        onValueChange = {
                            text = it
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = FigSecondarySurfaceColor,
                            textColor = FigSecondaryContentColor,
                            cursorColor = FigPrimaryBlack,
                        )
                    )
                }
                Text(
                    text = "e.gextra sauce less spicy etc",
                    style = MaterialTheme.typography.caption,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = FigSecondaryContentColor,
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, top = 2.dp)
                        .fillMaxWidth()
                )
            }
        }



    }
}


@Preview("BottomSheetContent")
@Composable
private fun BottomSheetContentPreview() {
    JetPackComposeWalkthroughTheme {
        BottomSheetContent(
            menuItem = MenuItem(
                id = 0,
                name = "Samosa",
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
                foodType = "Samosa"
            )
        )
    }
}