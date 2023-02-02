package com.example.spotimusic.feature_products.di

import com.example.spotimusic.core.utils.Constants.BASE_URL
import com.example.spotimusic.feature_products.data.remote.FakeStoreApiService
import com.example.spotimusic.feature_products.domain.repository.ProductRepository
import com.example.spotimusic.feature_products.data.repository.ProductRepositoryImpl
import com.example.spotimusic.feature_products.domain.use_cases.GetCategoriesUseCase
import com.example.spotimusic.feature_products.domain.use_cases.get_Products.GetProductsUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProductModule {

    @Singleton
    @Provides
    fun provideFakeStore(): FakeStoreApiService {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FakeStoreApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesProductRepository(api: FakeStoreApiService): ProductRepository {
        return ProductRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetProductsUseCase(productsRepository: ProductRepository): GetProductsUseCases {
        return GetProductsUseCases(productsRepository)
    }

    @Provides
    @Singleton
    fun provideGetCategoriesUseCase(productsRepository: ProductRepository): GetCategoriesUseCase {
        return GetCategoriesUseCase(productsRepository)
    }
}