package com.example.mimenu.ui.buy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.databinding.FragmentFoodDetailBinding


class FoodDetailFragment : Fragment() {

    private lateinit var binding : FragmentFoodDetailBinding
    private lateinit var food : FoodEntity
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
        food = args.food

        setDataFood()
        binding.btnDeleteFood.setOnClickListener { deleteFood() }
        binding.btnAddFood.setOnClickListener { addFood() }
        binding.btnAddOrder.setOnClickListener { addOrder() }
    }

    private fun setDataFood(){
        binding.tvNameFoodDetail.text = food.name
        binding.tvDescriptionFoodDetail.text = food.description
        binding.ivFoodDetail.setImageResource(food.img)
        binding.tvPriceFoodDetail.text = "$ ${food.price}"
        binding.tvQuantityFoodDetail.text = quantityFood.toString()
    }
    private  fun deleteFood(){
        if(quantityFood > 1){
            quantityFood--
            binding.tvQuantityFoodDetail.text = quantityFood.toString()
            binding.tvPriceFoodDetail.text = getPriceFood(food.price,quantityFood)
        }
    }
    private fun addFood(){
        quantityFood++
        binding.tvQuantityFoodDetail.text = quantityFood.toString()
        binding.tvPriceFoodDetail.text = getPriceFood(food.price,quantityFood)

    }
    private fun getPriceFood (price : Int, quantity: Int) : String {
        val price = price * quantity
        return "$ $price"
    }
    private fun addOrder(){

    }

}