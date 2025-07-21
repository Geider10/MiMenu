package com.example.mimenu

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.mimenu.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNav = binding.bottomNavigationView

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        val barConfig = AppBarConfiguration(setOf(
            R.id.firstFragment, R.id.secondFragment, R.id.cartFragment, R.id.moreFragment
        ))


        NavigationUI.setupWithNavController(binding.toolbar,navController,barConfig)
        bottomNav.setupWithNavController(navController)
    }
    fun enableBottomNav(){
        bottomNav.visibility = View.VISIBLE
    }
    fun disableBottomNav(){
        bottomNav.visibility = View.GONE
    }
    fun enableToolBar(){
        binding.toolbar.visibility = View.VISIBLE
    }
    fun disableToolBar(){
        binding.toolbar.visibility = View.GONE
    }
}