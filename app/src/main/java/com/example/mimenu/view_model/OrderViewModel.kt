package com.example.mimenu.view_model

import androidx.lifecycle.ViewModel
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.repository.Repository

class OrderViewModel: ViewModel() {

    private val repo = Repository()

    fun create(order: OrderEntity){
        repo.createOrder(order)
    }
}