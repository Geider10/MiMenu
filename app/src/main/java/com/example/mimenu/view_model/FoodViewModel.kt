package com.example.mimenu.view_model

import androidx.lifecycle.ViewModel
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.repository.Repository

class FoodViewModel : ViewModel() {
    private val repo = Repository()

    val getAll : List<FoodEntity> = repo.getAllFood
    val getOffer : List<FoodEntity> = repo.getFoodOffer

}