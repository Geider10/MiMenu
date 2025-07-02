package com.example.mimenu.repository

import androidx.lifecycle.LiveData
import com.example.mimenu.data.AppDataBase
import com.example.mimenu.data.DataProvider
import com.example.mimenu.data.Entities.CategoryEntity
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.data.Entities.OrderEntity

class Repository {

    private val db = AppDataBase.getDataBase()
    private val provider = DataProvider

    //order
    suspend fun createOrder(order: OrderEntity){
        db.orderDao().create(order)
    }
    val getAllOrders : LiveData<List<OrderEntity>> = db.orderDao().getAll()

    suspend fun deleteOrder(order: OrderEntity){
        db.orderDao().delete(order)
    }
    suspend fun updateOrder(order : OrderEntity){
        db.orderDao().update(order)
    }
    //food
    val getAllFood : List<FoodEntity> = provider.getAllFood()
    val getFoodOffer : List<FoodEntity> = provider.getFoodOffer()
    //category
    val getAllCategory : List<CategoryEntity> = provider.getAllCategory()
}