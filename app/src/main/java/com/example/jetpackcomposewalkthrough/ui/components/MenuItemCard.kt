package com.example.jetpackcomposewalkthrough.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.model.MenuItem
import com.example.jetpackcomposewalkthrough.ui.theme.JetPackComposeWalkthroughTheme


@Composable
fun MenuItemCard(
    menuItem: MenuItem,
    onClick: () -> Unit
) {
    androidx.compose.material.Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp),
        color = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onSurface
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (card, name, price, image) = createRefs()

            androidx.compose.material.Surface(
                modifier = Modifier
                    .constrainAs(card) {
                        start.linkTo(parent.start, margin = 16.dp)
                        end.linkTo(parent.end, margin = 16.dp)
                        top.linkTo(parent.top, margin = 32.dp)
                        bottom.linkTo(parent.bottom)

                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints

                    },
                shape = MaterialTheme.shapes.medium,
            ) {

            }

            NetworkImage(
                imageUrl = menuItem.image,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1.40f)
                    .constrainAs(image) {
//                        end.linkTo(parent.end)
//                        top.linkTo(parent.top)
//                        bottom.linkTo(parent.bottom)
                        start.linkTo(card.start)
                        end.linkTo(card.end)
                        bottom.linkTo(name.top)

                    },
                previewPlaceholder = R.drawable.menu_item_quarter_pounder_with_cheese_meal
            )

            Text(
                text = menuItem.name,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .constrainAs(name) {
                        start.linkTo(card.start)
                        end.linkTo(card.end)
                        top.linkTo(card.bottom)
                        bottom.linkTo(price.top, margin = 16.dp)

                        width = Dimension.fillToConstraints
                        height = Dimension.wrapContent
                    }
            )

            Text(
                text = "$" + "%.2f".format(menuItem.price),
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier
                    .constrainAs(price) {
                        start.linkTo(card.start)
                        end.linkTo(card.end)
                        top.linkTo(name.bottom)
                        bottom.linkTo(card.bottom, margin = 16.dp)

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
                name = "Double Quarter Pounder with Cheese Meal",
                description = "",
                image = "",
                price = 0.00,
                categoryId = 0
            ),
            onClick = {}
        )
    }
}