package com.example.jetpackcomposewalkthrough.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.ui.theme.*

@Composable
fun TopLocationBar() {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        FigGradientOne,
                        FigGradientTwo,
                        FigGradientThree
                    )
                )
            )
            .fillMaxWidth()
            .height(130.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
        ) {
            val (locationIcon, deliverText, addressText, arrowDownIcon, searchBox,  profileBox, filterBox ) = createRefs()

            Box(
                modifier = Modifier.constrainAs(locationIcon){
                    start.linkTo(parent.start, margin = 5.dp)
                    // end.linkTo(deliverText.start)
                    top.linkTo(parent.top, margin = 20.dp)

                }
            ){
                PainterIcon(
                    painter = painterResource(id = R.drawable.location),
                    modifier = Modifier
                        .height(22.dp)
                        .width(22.dp)
                        .padding(start = 10.dp),
                    tint = FigCrimson
                )
            }

            Box(
                modifier = Modifier.constrainAs(deliverText){
                    start.linkTo(locationIcon.end, margin = 5.dp)
                    //end.linkTo(parent.end, margin = 5.dp)
                    top.linkTo(parent.top, margin = 15.dp)

                }
            ){
                Text(
                    text = "Deliver to",
                    style = MaterialTheme.typography.body2,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = FigCrimson
                )
            }

            Box(
                modifier = Modifier
                    .constrainAs(profileBox) {
                        //start.linkTo(deliverText.end, margin = 5.dp)
                        end.linkTo(parent.end, margin = 5.dp)
                        top.linkTo(parent.top, margin = 10.dp)

                    }
                    .clip(CircleShape)
                    .background(FigCrimson)
            ){
                PainterIcon(
                    painter = painterResource(id = R.drawable.profile),
                    modifier = Modifier
                        .padding(10.dp)
                        .height(22.dp)
                        .width(22.dp),
                    tint = Color.White
                )
            }

            Row(
                modifier = Modifier
                    .constrainAs(addressText) {
                        start.linkTo(locationIcon.end, margin = 5.dp)
                        top.linkTo(deliverText.bottom, margin = 2.dp)

                    }
                    .wrapContentSize()
            ) {
                Text(
                    text = "Baridhara Diplomatic Zone...",
                    style = MaterialTheme.typography.subtitle2,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = FigBlack
                )

                PainterIcon(
                    painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                    modifier = Modifier,

                    tint = FigBlack
                )
            }



            Box(
                modifier = Modifier
                    .constrainAs(searchBox) {
                        start.linkTo(parent.start, margin = 12.dp)
                        top.linkTo(addressText.bottom, margin = 5.dp)

                    }
                    .width(250.dp)
            ){
                SearchBar(
                    text = "Search for restaurant name...",
                    onClick = {}
                )
            }

            Box(
                modifier = Modifier
                    .constrainAs(filterBox) {
                        //start.linkTo(deliverText.end, margin = 5.dp)
                        end.linkTo(parent.end, margin = 5.dp)
                        top.linkTo(profileBox.bottom, margin = 5.dp)

                    }
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
            ){
                PainterIcon(
                    painter = painterResource(id = R.drawable.filter),
                    modifier = Modifier
                        .padding(10.dp)
                        .height(22.dp)
                        .width(22.dp),
                    tint = FigCrimson
                )
            }


        }
    }
}



@Preview("TopLocationBar")
@Composable
private fun TopLocationBarPreview() {
    JetPackComposeWalkthroughTheme {
        TopLocationBar(

        )
    }
}
