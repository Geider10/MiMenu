package com.example.mimenu.data.Entities

data class FoodEntity (
    val id : Int,
    val name : String,
    val price : Int,
    val description : String,
    val category : String,
    val img : Int,
    val discount : Int? = null
        ) : java.io.Serializable