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
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.databinding.FragmentFoodDetailBinding
import com.example.mimenu.view_model.OrderViewModel


class FoodDetailFragment : Fragment() {

    private lateinit var binding : FragmentFoodDetailBinding
    private val orderViewModel by viewModels<OrderViewModel>()

    private lateinit var order : OrderEntity
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
        order = args.order

        setDataFood()
        binding.btnDeleteFood.setOnClickListener { deleteFood() }
        binding.btnAddFood.setOnClickListener { addFood() }
        binding.btnClickOrder.setOnClickListener { onClickOrder() }
    }

    private fun setDataFood(){
        quantityFood = order.quantity
        binding.tvNameFoodDetail.text = order.name
        binding.tvDescriptionFoodDetail.text = order.description
        binding.ivFoodDetail.setImageResource(order.img)
        binding.tvPriceFoodDetail.text = formatPriceFood(order.price,quantityFood)
        binding.tvQuantityFoodDetail.text = quantityFood.toString()

        println(order.id)
        if(order.id == 0){
            binding.btnClickOrder.text = "Agregar"
        }else{
            binding.btnClickOrder.text = "Guardar cambio"
        }

    }
    private fun deleteFood(){
        if(quantityFood > 1){
            quantityFood--
            binding.tvQuantityFoodDetail.text = quantityFood.toString()
            binding.tvPriceFoodDetail.text = formatPriceFood(order.price,quantityFood)
        }
    }
    private fun addFood(){
        quantityFood++
        binding.tvQuantityFoodDetail.text = quantityFood.toString()
        binding.tvPriceFoodDetail.text = formatPriceFood(order.price,quantityFood)

    }
    private fun formatPriceFood (price : Int, quantity: Int) : String {
        val price = price * quantity
        return "$ ${price}"
    }
    private fun onClickOrder(){
        var priceTotal = binding.tvPriceFoodDetail.text.toString()
        val quantity = binding.tvQuantityFoodDetail.text.toString()
        priceTotal = priceTotal.replace("$","").trim()
        val orderCopy = order.copy(priceTotal = priceTotal.toInt(), quantity = quantity.toInt())

        if (order.id == 0){
            orderViewModel.create(orderCopy)
            findNavController().navigate(R.id.action_foodDetailFragment_to_secondFragment)
            Toast.makeText(requireContext(),"Agregaste un pedido con éxito", Toast.LENGTH_LONG).show()
        }else if(order.id != 0){
            orderViewModel.update(orderCopy)
            findNavController().navigate(R.id.action_foodDetailFragment_to_cartFragment)
            Toast.makeText(requireContext(),"Actualizaste un pedido con éxito", Toast.LENGTH_LONG).show()
        }

    }

}