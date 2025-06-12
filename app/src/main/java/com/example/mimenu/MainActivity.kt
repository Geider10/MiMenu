package com.example.mimenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.commit
import com.example.mimenu.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{

    private lateinit var binding : ActivityMainBinding
    private lateinit var navigation : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigation = binding.bottomNavigationView
        navigation.setOnNavigationItemSelectedListener  (this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.nav_item_one -> {
                supportFragmentManager.commit {
                    replace(R.id.bottomNavigationView,FirstFragment())
                    addToBackStack("replacment")
                }
                return true
            }
            R.id.nav_item_two -> {
                supportFragmentManager.commit {
                    replace(R.id.bottomNavigationView,SecondFragment())
                    addToBackStack("replacment")

                }
                return true
            }
            else -> return  false
        }
    }
}