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
    fun getFoodOffer() : List<FoodModel>{
        return DataSetMock.foodList.filter { f -> f.discount != null }.subList(0,2)
    }
    fun getAllCategories() : List<String>{
        return DataSetMock.categoryList
    }
    fun getAllBanners() : List<Int>{
        return DataSetMock.bannerList
    }
    fun getAllVouchers () : List<VoucherModel> {
        return DataSetMock.voucherList
    }
    private fun stringToLocalDate(date : String) : LocalDate {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyy")
        return LocalDate.parse(date,formatter)
    }
}
