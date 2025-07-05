package com.example.mimenu.ui.buy

import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.data.model.FoodModel

interface OnFoodClick {

    fun onClick(food: FoodModel)
}