package com.example.spotimusic.feature_products.domain.models

import com.example.spotimusic.feature_products.data.dto.Rating

data class ProductDetails(
    val image: String,
    val category: String,
    val price: Double,
    val rating: Rating,
    val title: String,
    val description: String,
    val id : Int
)
