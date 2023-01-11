package com.example.jetpackcomposewalkthrough.data

import com.example.jetpackcomposewalkthrough.model.CircularMenuItem
import com.example.jetpackcomposewalkthrough.model.SliderMenuItem

object SliderRepository {
    fun getSliderItemData(): List<SliderMenuItem> {
        return listOf(
            SliderMenuItem(
                id = 1,
                image = "https://raw.githubusercontent.com/Sohanur-Rahman642/JetPackComposeWalkthrough/main/app/src/main/res/drawable-nodpi/" + "banner1.png",
            ),
            SliderMenuItem(
                id = 2,
                image = "https://raw.githubusercontent.com/Sohanur-Rahman642/JetPackComposeWalkthrough/main/app/src/main/res/drawable-nodpi/" + "banner2.png",
            ),
            SliderMenuItem(
                id = 3,
                image = "https://raw.githubusercontent.com/Sohanur-Rahman642/JetPackComposeWalkthrough/main/app/src/main/res/drawable-nodpi/" + "banner1.png",
            ),
            SliderMenuItem(
                id = 4,
                image = "https://raw.githubusercontent.com/Sohanur-Rahman642/JetPackComposeWalkthrough/main/app/src/main/res/drawable-nodpi/" + "banner2.png",
            ),
            SliderMenuItem(
                id = 5,
                image = "https://raw.githubusercontent.com/Sohanur-Rahman642/JetPackComposeWalkthrough/main/app/src/main/res/drawable-nodpi/" + "banner1.png",
            ),
            SliderMenuItem(
                id = 6,
                image = "https://raw.githubusercontent.com/Sohanur-Rahman642/JetPackComposeWalkthrough/main/app/src/main/res/drawable-nodpi/" + "banner1.png",
            ),
            SliderMenuItem(
                id = 3,
                image = "https://raw.githubusercontent.com/Sohanur-Rahman642/JetPackComposeWalkthrough/main/app/src/main/res/drawable-nodpi/" + "banner2.png",
            ),
            SliderMenuItem(
                id = 7,
                image = "https://raw.githubusercontent.com/Sohanur-Rahman642/JetPackComposeWalkthrough/main/app/src/main/res/drawable-nodpi/" + "banner1.png",
            ),
            SliderMenuItem(
                id = 8,
                image = "https://raw.githubusercontent.com/Sohanur-Rahman642/JetPackComposeWalkthrough/main/app/src/main/res/drawable-nodpi/" + "banner2.png",
            ),
        )
    }
}