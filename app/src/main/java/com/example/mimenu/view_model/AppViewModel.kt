package com.example.mimenu.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mimenu.data.model.FoodModel
import com.example.mimenu.data.model.OrderModel
import com.example.mimenu.data.model.VoucherModel
import com.example.mimenu.data.repository.AppRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppViewModel : ViewModel() {
    private val repo = AppRepository()

    //oders
    val getAllOrders: LiveData<List<OrderModel>> = repo.getAllOrders
    fun createOrder(order: OrderModel){
        viewModelScope.launch(Dispatchers.IO) {
            repo.createOrder(order)
        }
    }
    fun deleteOrder(order: OrderModel){
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteOrder(order)
        }
    }
    fun updateOrder(order: OrderModel){
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateOrder(order)
        }
    }
    //food
    val getAllFoods : List<FoodModel> = repo.getAllFoods
    fun getAllFoodOffer(quantity: Int = 0) : List<FoodModel> = repo.getAllFoodOffer(quantity)
    //category
    val getAllCategories : List<String> = repo.getAllCategories
    //banner
    val getAllBanners : List<Int> = repo.getAllBanners
    //voucher
    fun getAllVouchers (quantity : Int = 0) : List<VoucherModel> = repo.getAllVouchers(quantity)

}