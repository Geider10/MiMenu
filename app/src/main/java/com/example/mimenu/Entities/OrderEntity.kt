package com.example.mimenu.Entities

data class OrderEntity (
    val id : Int,
    val name: String,
    val description: String,
    val price: Int,
    val img : Int,
    val priceTotal : Int,
    val quantity : Int,
        ): java.io.Serializable