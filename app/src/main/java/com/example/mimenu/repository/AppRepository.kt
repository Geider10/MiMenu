package com.example.mimenu.repository

import androidx.lifecycle.LiveData
import com.example.mimenu.data.local.AppDataBase
import com.example.mimenu.data.mock.DataMockProvider
import com.example.mimenu.data.model.FoodModel
import com.example.mimenu.data.model.OrderModel
import com.example.mimenu.data.model.VoucherModel
import com.example.mimenu.utils.AppUtil

class AppRepository {

    private val db = AppDataBase.getDataBase()
    private val provider = DataMockProvider()
    private val appUtil = AppUtil.getInstance()

    //order
    val getAllOrders : LiveData<List<OrderModel>> = db.orderDao().getAll()
    suspend fun createOrder(order:  OrderModel){
        val orderEntity = appUtil.mapOrder(order)
        db.orderDao().create(orderEntity)
    }
    suspend fun deleteOrder(order: OrderModel){
        val orderEntity = appUtil.mapOrder(order)
        db.orderDao().delete(orderEntity)
    }
    suspend fun updateOrder(order : OrderModel){
        val orderEntity = appUtil.mapOrder(order)
        db.orderDao().update(orderEntity)
    }
    //food
    val getAllFoods : List<FoodModel> = provider.getAllFoods()
    fun getAllFoodOffer(quantity: Int) : List<FoodModel> = provider.getFoodOffer(quantity)
    //category
    val getAllCategories : List<String> = provider.getAllCategories()
    //banners
    val getAllBanners : List<Int> = provider.getAllBanners()
    //voucher
    fun getAllVouchers (quantity : Int ): List<VoucherModel> = provider.getAllVouchers(quantity)

}