package com.devanand.tascavegetables.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devanand.tascavegetables.repository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val repository: CartRepository) : ViewModel() {

    val cartItems : LiveData<MutableList<String>> = repository.cartItems

    fun addItemToCart(item : String){
        viewModelScope.launch {
            repository.addItemToCart(item)
        }
    }

    private val _cartCount = MutableLiveData(0)
    val cartCount: LiveData<Int> get() = _cartCount

    fun addToCart() {
        _cartCount.value = (_cartCount.value ?: 0) + 1
    }

}