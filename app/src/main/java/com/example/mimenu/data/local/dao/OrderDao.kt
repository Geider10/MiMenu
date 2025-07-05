package com.example.mimenu.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mimenu.data.local.Entities.OrderEntity
import com.example.mimenu.data.model.OrderModel

@Dao
interface OrderDao {
    @Query("SELECT * FROM `order`")
    fun getAll() : LiveData<List<OrderModel>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(order : OrderEntity)
    @Delete
    suspend fun delete(order: OrderEntity)
    @Update
    suspend fun update(order: OrderEntity)
}