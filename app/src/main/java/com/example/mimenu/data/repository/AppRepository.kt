package com.example.mimenu.data.repository

import androidx.lifecycle.LiveData
import com.example.mimenu.data.AppDataBase
import com.example.mimenu.data.mock.DataMockProvider
import com.example.mimenu.data.Entities.CategoryEntity
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.data.model.FoodModel
import com.example.mimenu.data.model.OrderModel
import com.example.mimenu.data.model.VoucherModel

class AppRepository {

    private val db = AppDataBase.getDataBase()
    private val provider = DataMockProvider

    //order
    val getAllOrders : LiveData<List<OrderModel>> = db.orderDao().getAll()
    suspend fun createOrder(order:  OrderModel){
        val orderEntity = mapOrder(order)
        db.orderDao().create(orderEntity)
    }
    suspend fun deleteOrder(order: OrderModel){
        val orderEntity = mapOrder(order)
        db.orderDao().delete(orderEntity)
    }
    suspend fun updateOrder(order : OrderModel){
        val orderEntity = mapOrder(order)
        db.orderDao().update(orderEntity)
    }
    //food
    val getAllFoods : List<FoodModel> = provider.getAllFoods()
    val getAllFoodOffer : List<FoodModel> = provider.getFoodOffer()
    //category
    val getAllCategories : List<String> = provider.getAllCategories()
    //banners
    val getAllBanners : List<Int> = provider.getAllBanners()
    //voucher
    val getAllVouchers : List<VoucherModel> = provider.getAllVouchers()
    private fun mapOrder(order: OrderModel) : OrderEntity{
        return  OrderEntity(
            id = order.id, name = order.name, description = order.description, img = order.img, price = order.price, priceTotal = order.priceTotal, quantity = order.quantity, discount = order.discount
        )
    }
}