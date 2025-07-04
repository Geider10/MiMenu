package com.example.mimenu.data.model

data class FoodModel (
    val id : Int,
    val name : String,
    val price : Int,
    val description : String,
    val category : String,
    val img : Int,
    val discount : Int?
        ): java.io.Serializable