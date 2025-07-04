package com.example.mimenu.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.data.model.VoucherModel
import com.example.mimenu.data.repository.AppRepository
import kotlinx.coroutines.launch

class AppViewModel : ViewModel() {
    private val repo = AppRepository()
    //oders
    val getAllOrders: LiveData<List<OrderEntity>> = repo.getAllOrders
    fun createOrder(order: OrderEntity){
        viewModelScope.launch {
            repo.createOrder(order)
        }
    }
    fun deleteOrder(order: OrderEntity){
        viewModelScope.launch {
            repo.deleteOrder(order)
        }
    }
    fun updateOrder(order: OrderEntity){
        viewModelScope.launch {
            repo.updateOrder(order)
        }
    }
    //food
    val getAllFoods : List<FoodEntity> = repo.getAllFoods
    val getAllFoodOffer : List<FoodEntity> = repo.getAllFoodOffer
    //category
    val getAllCategories : List<String> = repo.getAllCategories
    //banner
    val getAllBanners : List<Int> = repo.getAllBanners
    //voucher
    val getAllVouchers : List<VoucherModel> = repo.getAllVouchers
}