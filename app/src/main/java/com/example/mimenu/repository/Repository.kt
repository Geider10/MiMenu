package com.example.mimenu.repository

import com.example.mimenu.data.AppDataBase
import com.example.mimenu.data.Entities.OrderEntity

class Repository {

    private val dbDao = AppDataBase.getDataBase()

    fun createOrder(order: OrderEntity){
        dbDao.orderDao().create(order)
    }
    fun getAllOrders() : List<OrderEntity>{
        val orderList = dbDao.orderDao().getAll()
        return orderList
    }
}