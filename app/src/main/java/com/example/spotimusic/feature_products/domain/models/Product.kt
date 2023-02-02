package com.example.spotimusic.feature_products.domain.models

import com.example.spotimusic.feature_products.data.dto.Rating

data class Product(
    val category: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)
