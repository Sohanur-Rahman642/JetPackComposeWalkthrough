package com.example.jetpackcomposewalkthrough.data

import com.example.jetpackcomposewalkthrough.R
import com.example.jetpackcomposewalkthrough.model.CircularMenuItem
import com.example.jetpackcomposewalkthrough.model.SliderMenuItem

object SliderRepository {
    fun getSliderItemData(): List<SliderMenuItem> {
        return listOf(
            SliderMenuItem(
                id = 1,
                image = "drawable://" + R.drawable.banner3,
            ),
            SliderMenuItem(
                id = 2,
                image = "drawable://" + R.drawable.banner2,
            ),
            SliderMenuItem(
                id = 3,
                image = "drawable://" + R.drawable.banner3,
            ),
            SliderMenuItem(
                id = 4,
                image = "drawable://" + R.drawable.banner2,
            ),
        )
    }
}