package com.example.mimenu.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.data.dao.OrderDao

@Database(entities = [OrderEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase(){
    abstract fun orderDao() : OrderDao
}