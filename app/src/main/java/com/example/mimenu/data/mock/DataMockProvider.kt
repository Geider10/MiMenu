package com.example.mimenu.data.mock

import com.example.mimenu.R
import com.example.mimenu.data.model.FoodModel
import com.example.mimenu.data.model.VoucherModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DataMockProvider {
    fun getAllFoods() : List<FoodModel>{
        return DataSetMock.foodList
    }
    fun getFoodOffer(quantity : Int) : List<FoodModel>{
        if(quantity == 0) return  DataSetMock.foodList.filter { f -> f.discount != null }
        return DataSetMock.foodList.filter { f -> f.discount != null }.subList(0,quantity)
    }
    fun getAllCategories() : List<String>{
        return DataSetMock.categoryList
    }
    fun getAllBanners() : List<Int>{
        return DataSetMock.bannerList
    }
    fun getAllVouchers (quantity : Int) : List<VoucherModel> {
        if(quantity == 0) return DataSetMock.voucherList
        return DataSetMock.voucherList.subList(0,quantity)
    }
    private fun stringToLocalDate(date : String) : LocalDate {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyy")
        return LocalDate.parse(date,formatter)
    }
}
