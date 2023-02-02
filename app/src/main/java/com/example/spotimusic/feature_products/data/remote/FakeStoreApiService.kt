package com.example.spotimusic.feature_products.data.remote

import com.example.spotimusic.feature_products.data.dto.ProductsDtoItem
import retrofit2.http.GET
import retrofit2.http.Path

interface FakeStoreApiService {

    @GET("Products")
    suspend fun getAllProducts() : List<ProductsDtoItem>

    @GET("Products/{productId}")
    suspend fun getProductById(@Path("productId") productInt: String): ProductsDtoItem

    @GET("Products/categories")
    suspend fun getCategories(): List<String>
}