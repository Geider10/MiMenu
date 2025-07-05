package com.example.mimenu.data.model

data class OrderModel (
    val id : Int = 0,
    val name : String,
    val price : Int,
    val description : String,
    val img : Int,
    val discount : Int? = null,
    val quantity : Int,
    val priceTotal : Int,
        ) : java.io.Serializable