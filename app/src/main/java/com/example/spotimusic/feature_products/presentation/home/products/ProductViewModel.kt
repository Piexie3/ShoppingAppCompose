package com.example.spotimusic.feature_products.presentation.home.products

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotimusic.core.utils.Resources
import com.example.spotimusic.feature_products.domain.use_cases.GetCategoriesUseCase
import com.example.spotimusic.feature_products.domain.use_cases.get_Products.GetProductsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductsUseCases: GetProductsUseCases,
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {
    private val _productsState = mutableStateOf(ProductState())
    val productsState: State<ProductState> = _productsState

    private val _categoriesState = mutableStateOf(emptyList<String>())
    val categoriesState: State<List<String>> = _categoriesState

    private val _selectedCategory = mutableStateOf("All")
    val selectedCategory: State<String> = _selectedCategory


    init {
        getProducts(selectedCategory.value)
        getCategories()
    }

    fun setCategory(value: String) {
        _selectedCategory.value = value
    }
    private fun getCategories(){
        viewModelScope.launch {
            _categoriesState.value = getCategoriesUseCase()
        }
    }

    fun getProducts(category: String) {
        viewModelScope.launch {
            getProductsUseCases().collectLatest { result ->
                when (result) {
                    is Resources.Success -> {
                        if (category == "All") {
                            _productsState.value = productsState.value.copy(
                                products = result.data ?: emptyList(),
                                isLoading = false
                            )
                        } else {
                            _productsState.value = productsState.value.copy(
                                products = result.data?.filter { it.category == category }
                                    ?: emptyList(),
                                isLoading = false
                            )
                        }
                    }
                    is Resources.Loading -> {
                        _productsState.value = productsState.value.copy(
                            isLoading = true
                        )
                    }
                    is Resources.Error -> {
                        _productsState.value = productsState.value.copy(
                            isLoading = false,
                            error = result.message?: "An Unexpected error occurred"
                        )
                    }
                }
            }
        }
    }
}