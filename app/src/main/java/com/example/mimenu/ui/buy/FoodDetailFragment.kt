package com.example.mimenu.ui.buy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mimenu.Entities.FoodEntity
import com.example.mimenu.databinding.FragmentFoodDetailBinding


class FoodDetailFragment : Fragment() {

    private lateinit var binding : FragmentFoodDetailBinding
    private var quantityFood = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args : FoodDetailFragmentArgs by navArgs()
        val food = args.food

        binding.tvNameFoodDetail.text = food.name
        binding.tvDescriptionFoodDetail.text = food.description
        binding.ivFoodDetail.setImageResource(food.img)
        binding.tvPriceFoodDetail.text = food.price.toString()
        binding.tvQuantityFoodDetail.text = quantityFood.toString()
    }

}