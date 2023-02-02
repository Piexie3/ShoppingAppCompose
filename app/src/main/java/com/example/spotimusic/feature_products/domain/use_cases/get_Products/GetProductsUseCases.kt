package com.example.spotimusic.feature_products.domain.use_cases.get_Products

import com.example.spotimusic.core.utils.Resources
import com.example.spotimusic.feature_products.data.dto.toProduct
import com.example.spotimusic.feature_products.domain.models.Product
import com.example.spotimusic.feature_products.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class GetProductsUseCases @Inject constructor(
    private val repository: ProductRepository
){
   operator fun invoke(): Flow<Resources<List<Product>>> = flow{
       try {
           emit(Resources.Loading())
           val products = repository.getProducts().map { it.toProduct() }
           emit(Resources.Success(products))
       }catch (e:Exception){
           e.printStackTrace()
           Resources.Error(e)
       }catch (e: IOException){
           e.printStackTrace()
           Resources.Error(e)
       }
   }

}