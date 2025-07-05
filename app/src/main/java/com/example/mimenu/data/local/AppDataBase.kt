package com.example.mimenu.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mimenu.AppMiMenu
import com.example.mimenu.data.local.Entities.OrderEntity
import com.example.mimenu.data.local.dao.OrderDao

@Database(entities = [OrderEntity::class], version = 2, exportSchema = false)
abstract class AppDataBase : RoomDatabase(){
    abstract fun orderDao() : OrderDao

    companion object {
        private var INSTANCE : AppDataBase? = null

        fun getDataBase() : AppDataBase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return  tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(AppMiMenu.instance.applicationContext, AppDataBase::class.java, "mimenu_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}