package com.example.spotimusic.feature_products.data.repository

import com.example.spotimusic.feature_products.data.dto.ProductsDtoItem
import com.example.spotimusic.feature_products.data.remote.FakeStoreApiService
import com.example.spotimusic.feature_products.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: FakeStoreApiService
): ProductRepository {
    override suspend fun getProducts(): List<ProductsDtoItem> {
        return api.getAllProducts()
    }

    override suspend fun getProductById(productId: String): ProductsDtoItem {
       return api.getProductById(productId)
    }

    override suspend fun getProductsCategories(): List<String> {
        return api.getCategories()
    }
}