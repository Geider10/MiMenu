package com.example.mimenu.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mimenu.Entities.FoodEntity
import com.example.mimenu.Entities.OrderEntity
import com.example.mimenu.R
import com.example.mimenu.databinding.FragmentCartBinding


class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setOrderMockeados(): List<OrderEntity>{
        val ordersList = listOf<OrderEntity>(
            OrderEntity(1,"Mega Doble Big Bang","Mega hamburguesa", 13900 ,  R.mipmap.hamburguer, 27800,2),
            OrderEntity(2,"Sundae de Frutilla","Sundae", 2900 ,  R.mipmap.sundae, 8700,3),
            OrderEntity(3,"Café con 2 Medialunas","2 medialunas de manteca acompañadas de un café", 2399,R.mipmap.coffe,  2399,1)
            )
        return  ordersList
    }
}