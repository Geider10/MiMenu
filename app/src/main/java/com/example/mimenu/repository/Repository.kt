package com.example.mimenu.repository

import com.example.mimenu.data.AppDataBase
import com.example.mimenu.data.Entities.OrderEntity

class Repository {

    private val dbDao = AppDataBase.getDataBase()

    fun createOrder(order: OrderEntity){
        dbDao.orderDao().create(order)
    }
    fun getAllOrders() : List<OrderEntity>{
        return dbDao.orderDao().getAll()
    }
    fun deleteOrder(order: OrderEntity){
        dbDao.orderDao().delete(order)
    }
    fun updateOrder(order : OrderEntity){
        dbDao.orderDao().update(order)
    }
}