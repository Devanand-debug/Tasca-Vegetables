package com.devanand.tascavegetables.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class CartRepository @Inject constructor() {

    private val _cartItems = MutableLiveData<MutableList<String>>(mutableListOf())
    val cartItems : LiveData<MutableList<String>> = _cartItems

    suspend fun addItemToCart(item : String){
        _cartItems.value?.add(item)
        _cartItems.postValue(_cartItems.value)
    }
}