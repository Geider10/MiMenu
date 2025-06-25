package com.example.mimenu.repository

import androidx.lifecycle.LiveData
import com.example.mimenu.data.AppDataBase
import com.example.mimenu.data.Entities.OrderEntity

class Repository {

    private val dbDao = AppDataBase.getDataBase()

    suspend fun createOrder(order: OrderEntity){
        dbDao.orderDao().create(order)
    }
    val getAllOrders : LiveData<List<OrderEntity>> = dbDao.orderDao().getAll()

    suspend fun deleteOrder(order: OrderEntity){
        dbDao.orderDao().delete(order)
    }
    suspend fun updateOrder(order : OrderEntity){
        dbDao.orderDao().update(order)
    }
}