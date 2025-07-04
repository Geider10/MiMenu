package com.example.mimenu.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.data.repository.AppRepository
import kotlinx.coroutines.launch

class OrderViewModel: ViewModel() {

    private val repo = AppRepository()

    fun create(order: OrderEntity){
        viewModelScope.launch {
            repo.createOrder(order)
        }
    }
    val getAll:LiveData<List<OrderEntity>> = repo.getAllOrders
    fun delete(order: OrderEntity){
        viewModelScope.launch {
            repo.deleteOrder(order)
        }
    }
    fun update(order: OrderEntity){
        viewModelScope.launch {
            repo.updateOrder(order)
        }
    }
}