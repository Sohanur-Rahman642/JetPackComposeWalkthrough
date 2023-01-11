package com.example.jetpackcomposewalkthrough.data

import com.example.jetpackcomposewalkthrough.model.CircularMenuItem
import com.example.jetpackcomposewalkthrough.model.SliderMenuItem

object SliderRepository {
    fun getSliderItemData(): List<SliderMenuItem> {
        return listOf(
            SliderMenuItem(
                id = 1,
                image = "banner1.png"
            ),
            SliderMenuItem(
                id = 2,
                image = "banner2.png"
            ),
            SliderMenuItem(
                id = 3,
                image = "banner1.png"
            ),
        )
    }
}