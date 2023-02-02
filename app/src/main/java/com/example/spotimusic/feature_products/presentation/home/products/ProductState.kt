package com.example.spotimusic.feature_products.presentation.home.products

import com.example.spotimusic.feature_products.domain.models.Product
import com.example.spotimusic.feature_products.domain.models.ProductDetails

data class ProductState(
    val isLoading: Boolean=false,
    val products: List<Product> = emptyList(),
    val product: ProductDetails?=null,
    val category: String = "",
    val error: String = ""
)
