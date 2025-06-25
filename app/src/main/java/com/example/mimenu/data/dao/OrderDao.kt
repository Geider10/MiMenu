package com.example.mimenu.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mimenu.data.Entities.OrderEntity

@Dao
interface OrderDao {
    @Query("SELECT * FROM `order`")
    fun getAll() : LiveData<List<OrderEntity>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(order : OrderEntity)
    @Delete
    suspend fun delete(order: OrderEntity)
    @Update
    suspend fun update(order: OrderEntity)
}