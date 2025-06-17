package com.example.mimenu.Entities

data class FoodEntity (
    val id : Int,
    val name : String,
    val price : Int,
    val description : String,
    val category : String,
    val img : Int
        ) : java.io.Serializable