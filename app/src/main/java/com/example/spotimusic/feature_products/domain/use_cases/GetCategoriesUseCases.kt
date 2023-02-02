package com.example.spotimusic.feature_products.domain.use_cases

import com.example.spotimusic.feature_products.domain.repository.ProductRepository

class GetCategoriesUseCase(
    private val productsRepository: ProductRepository
) {
    suspend operator fun invoke(): List<String> {
        val categories = productsRepository.getProductsCategories()
        return listOf("All") + categories
    }
}