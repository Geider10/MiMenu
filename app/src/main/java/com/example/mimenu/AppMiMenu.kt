package com.example.mimenu

import android.app.Application

class AppMiMenu : Application() {
    companion object{
        lateinit var instance : AppMiMenu
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}