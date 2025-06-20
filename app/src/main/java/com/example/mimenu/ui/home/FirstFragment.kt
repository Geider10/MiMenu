package com.example.mimenu.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.mimenu.R
import com.example.mimenu.data.AppDataBase
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding : FragmentFirstBinding
    private lateinit var appDB : AppDataBase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //createDataBase()
    }
    private fun createDataBase(){
        appDB = Room.databaseBuilder(requireContext(), AppDataBase::class.java, "mimenu_database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
        appDB.orderDao().create(OrderEntity(2,"Sundae de Frutilla","Sundae", 2900 ,  R.mipmap.sundae, 8700,3))
    }


}