package com.example.mimenu.data.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "order")
data class OrderEntity (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val name: String,
    val description: String,
    val price: Int,
    val img : Int,
    val priceTotal : Int,
    val quantity : Int,
    val discount : Int? = null
): java.io.Serializable