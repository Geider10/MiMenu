package com.example.mimenu.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mimenu.data.Entities.OrderEntity

@Dao
interface OrderDao {
    @Query("SELECT * FROM `order`")
    fun getAll() : List<OrderEntity>
    @Insert
    fun create(order : OrderEntity)
    @Delete
    fun delete(order: OrderEntity)
}