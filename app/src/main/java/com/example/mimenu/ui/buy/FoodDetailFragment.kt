package com.example.mimenu.ui.buy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mimenu.R
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.databinding.FragmentFoodDetailBinding
import com.example.mimenu.view_model.OrderViewModel


class FoodDetailFragment : Fragment() {

    private lateinit var binding : FragmentFoodDetailBinding
    private val orderViewModel by viewModels<OrderViewModel>()

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
        return "$ ${price}"
    }
    private fun addOrder(){
        val name = binding.tvNameFoodDetail.text.toString()
        val description = binding.tvDescriptionFoodDetail.text.toString()
        var priceTotal = binding.tvPriceFoodDetail.text.toString()
        val quantity = binding.tvQuantityFoodDetail.text.toString()

        priceTotal = priceTotal.replace("$","").trim()
        val order = OrderEntity(name = name, description = description, price = food.price, img = food.img, priceTotal = priceTotal.toInt(), quantity = quantity.toInt())
        orderViewModel.create(order)

        findNavController().navigate(R.id.action_foodDetailFragment_to_secondFragment)
        Toast.makeText(requireContext(),"Se agrego con exito", Toast.LENGTH_LONG).show()
    }

}