package com.example.boarding.ui

import androidx.annotation.DrawableRes
import com.example.boarding.R

sealed class BoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    data object First : BoardingPage(R.drawable.illustration, "First", "First description")
    data object Second : BoardingPage(R.drawable.illustration_2, "Second", "Second description")
    data object Third : BoardingPage(R.drawable.illustration__1, "Third", "Third description")

}