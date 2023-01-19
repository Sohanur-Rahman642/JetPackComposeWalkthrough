package com.example.jetpackcomposewalkthrough.ui.components
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.constraintlayout.compose.layoutId
import com.example.jetpackcomposewalkthrough.R


@Composable
fun CollapsingToolbar(lazyScrollState: LazyListState) {
    val context = LocalContext.current
    val motionScene = remember {
        context.resources.openRawResource(R.raw.collapse_toolbar).readBytes().decodeToString()
    }

    val progress by animateFloatAsState(
        targetValue = if (lazyScrollState.firstVisibleItemIndex in 0..1) 0f else 1f,
        tween(500)
    )
    val motionHeight by animateDpAsState(
        targetValue = if (lazyScrollState.firstVisibleItemIndex in 0..1) 230.dp else 56.dp,
        tween(500)
    )

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .height(motionHeight)
    ) {

        val boxProperties = motionProperties(id = "box")
//        val startColor = Color(boxProperties.value.color("custome"))
        Box(
            modifier = Modifier
                .layoutId("box")
                .background(boxProperties.value.color("background"))
        )

        Image(
            modifier = Modifier
                .layoutId("help_image"),
            painter = painterResource(id = R.drawable.burger_xpress_cover),
            contentDescription = ""
        )

        Icon(
            modifier = Modifier.layoutId("close_button"),
            imageVector = Icons.Filled.Close,
            tint = Color.White
        )

        Text(
            modifier = Modifier.layoutId("title"),
            text = "Help",
            color = Color.White,
            fontSize = 18.sp
        )

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    CollapsingToolbar()
}
