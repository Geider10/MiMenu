package com.example.mimenu.view_model

import androidx.lifecycle.ViewModel
import androidx.room.Index.Order
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.repository.Repository

class OrderViewModel: ViewModel() {

    private val repo = Repository()

    fun create(order: OrderEntity){
        repo.createOrder(order)
    }
    fun getAll():List<OrderEntity>{
        val orderList = repo.getAllOrders()
        return orderList
    }
    fun delete(order: OrderEntity){
        repo.deleteOrder(order)
    }
    fun update(order: OrderEntity){
        repo.updateOrder(order)
    }
}