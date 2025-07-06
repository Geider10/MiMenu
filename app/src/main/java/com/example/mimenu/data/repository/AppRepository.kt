package com.example.mimenu.data.repository

import androidx.lifecycle.LiveData
import com.example.mimenu.data.local.AppDataBase
import com.example.mimenu.data.mock.DataMockProvider
import com.example.mimenu.data.local.Entities.OrderEntity
import com.example.mimenu.data.model.FoodModel
import com.example.mimenu.data.model.OrderModel
import com.example.mimenu.data.model.VoucherModel

class AppRepository {

    private val db = AppDataBase.getDataBase()
    private val provider = DataMockProvider()

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
    fun getAllFoodOffer(quantity: Int) : List<FoodModel> = provider.getFoodOffer(quantity)
    //category
    val getAllCategories : List<String> = provider.getAllCategories()
    //banners
    val getAllBanners : List<Int> = provider.getAllBanners()
    //voucher
    fun getAllVouchers (quantity : Int ): List<VoucherModel> = provider.getAllVouchers(quantity)

    private fun mapOrder(order: OrderModel) : OrderEntity {
        return  OrderEntity(
            id = order.id, name = order.name, description = order.description, img = order.img, price = order.price, priceTotal = order.priceTotal, quantity = order.quantity, discount = order.discount
        )
    }
}