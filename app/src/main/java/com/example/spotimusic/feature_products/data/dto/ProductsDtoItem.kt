package com.example.spotimusic.feature_products.data.dto

import com.example.spotimusic.feature_products.domain.models.Product
import com.example.spotimusic.feature_products.domain.models.ProductDetails

data class ProductsDtoItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)

fun ProductsDtoItem.toProduct(): Product {
    return Product(
        category = category,
        id = id,
        image = image,
        price = price,
        rating = rating,
        title = title
    )
}

fun ProductsDtoItem.toProductDetails(): ProductDetails{
    return ProductDetails(
        image = image,
        id = id,
        price = price,
        rating= rating,
        title=title,
        description = description,
        category = category
    )
}