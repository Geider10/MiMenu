package com.example.mimenu.data.repository

import androidx.lifecycle.LiveData
import com.example.mimenu.data.AppDataBase
import com.example.mimenu.data.mock.DataMockProvider
import com.example.mimenu.data.Entities.CategoryEntity
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.data.model.VoucherModel

class AppRepository {

    private val db = AppDataBase.getDataBase()
    private val provider = DataMockProvider

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
    val getAllFoods : List<FoodEntity> = provider.getAllFood()
    val getAllFoodOffer : List<FoodEntity> = provider.getFoodOffer()
    //category
    val getAllCategories : List<String> = provider.getAllCategories()
    //banners
    val getAllBanners : List<Int> = provider.getAllBanners()
    //voucher
    val getAllVouchers : List<VoucherModel> = provider.getAllVouchers()
}