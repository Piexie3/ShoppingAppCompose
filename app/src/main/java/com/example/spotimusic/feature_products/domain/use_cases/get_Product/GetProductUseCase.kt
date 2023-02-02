package com.example.spotimusic.feature_products.domain.use_cases.get_Product

import com.example.spotimusic.core.utils.Resources
import com.example.spotimusic.feature_products.data.dto.toProductDetails
import com.example.spotimusic.feature_products.domain.models.ProductDetails
import com.example.spotimusic.feature_products.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class GetProductUseCases @Inject constructor(
    private val repository: ProductRepository
){
    operator fun invoke(productId: String): Flow<Resources<ProductDetails>> = flow{
        try {
            emit(Resources.Loading())
            val product = repository.getProductById(productId).toProductDetails()
            emit(Resources.Success(product))
        }catch (e:Exception){
            e.printStackTrace()
            Resources.Error(e)
        }catch (e: IOException){
            e.printStackTrace()
            Resources.Error(e)
        }
    }

}