package com.example.spotimusic.feature_products.domain.repository

import com.example.spotimusic.feature_products.data.dto.ProductsDtoItem

interface ProductRepository {
    suspend fun getProducts(): List<ProductsDtoItem>
    suspend fun getProductById(productId: String): ProductsDtoItem
    suspend fun getProductsCategories(): List<String>
}