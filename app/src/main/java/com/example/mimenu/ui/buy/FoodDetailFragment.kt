package com.example.mimenu.ui.buy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mimenu.MainActivity
import com.example.mimenu.R
import com.example.mimenu.data.model.OrderModel
import com.example.mimenu.databinding.FragmentFoodDetailBinding
import com.example.mimenu.utils.AppUtil
import com.example.mimenu.view_model.AppViewModel


class FoodDetailFragment : Fragment() {

    private lateinit var binding : FragmentFoodDetailBinding
    private val appViewModel by viewModels<AppViewModel>()
    private val appUtil = AppUtil.getInstance()
    private lateinit var order : OrderModel
    private var quantityFood = 0
    private var priceFood = 0
    private var viewType = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args : FoodDetailFragmentArgs by this.navArgs()
        order = args.order
        viewType = args.viewType

        setDataFood()
        binding.btnDeleteFood.setOnClickListener { deleteFood() }
        binding.btnAddFood.setOnClickListener { addFood() }
        binding.btnClickOrder.setOnClickListener { onClickOrder() }

        var main = requireActivity() as MainActivity
        main.disableBottomNav()
    }

    override fun onDestroy() {
        super.onDestroy()
        var main = requireActivity() as MainActivity
        main.enableBottomNav()
    }
    private fun setDataFood() {
        if (viewType == 1 || viewType == 3) {
            binding.tvActionFoodDetail.text = "Agregar"
        } else {
            binding.tvActionFoodDetail.text = "Guardar cambio"
        }

        if (order.discount != null) {
            val offer = (order.price * order.discount!!) / 100
            val priceOffer = order.price - offer
            priceFood = priceOffer

        } else {
            priceFood = order.price
            binding.tvPriceRemoveFoodDetail.visibility = View.GONE
            binding.tvDiscountFoodDetail.visibility = View.GONE
        }
        quantityFood = order.quantity
        binding.tvNameFoodDetail.text = order.name
        binding.tvDescriptionFoodDetail.text = order.description
        binding.ivFoodDetail.setImageResource(order.img)
        val priceRemove = appUtil.formatTextToStrikeThrough("$ ${order.price}")
        binding.tvPriceRemoveFoodDetail.text = priceRemove
        binding.tvPriceFoodDetail.text = "$ $priceFood"
        binding.tvDiscountFoodDetail.text = "${order.discount}% OFF"

        binding.tvPriceTotalFoodDetail.text = formatPriceTotalFood(priceFood,quantityFood)
        binding.tvQuantityFoodDetail.text = quantityFood.toString()
        Log.i("Food Detail", "Descuento : ${order.discount}")
    }
    private fun deleteFood(){
        if(quantityFood > 1){
            quantityFood--
            binding.tvQuantityFoodDetail.text = quantityFood.toString()
            binding.tvPriceTotalFoodDetail.text = formatPriceTotalFood(priceFood,quantityFood)
        }
    }
    private fun addFood(){
        quantityFood++
        binding.tvQuantityFoodDetail.text = quantityFood.toString()
        binding.tvPriceTotalFoodDetail.text = formatPriceTotalFood(priceFood,quantityFood)

    }
    private fun formatPriceTotalFood (price : Int, quantity: Int) : String {
        val price = price * quantity
        return "$ $price"
    }

    private fun onClickOrder(){
        var priceTotal = binding.tvPriceTotalFoodDetail.text.toString()
        val quantity = binding.tvQuantityFoodDetail.text.toString()
        priceTotal = priceTotal.replace("$","").trim()
        val orderCopy = order.copy(priceTotal = priceTotal.toInt(), quantity = quantity.toInt())

        if(viewType == 1){
            appViewModel.createOrder(orderCopy)
            findNavController().navigate(R.id.action_foodDetailFragment_to_secondFragment)
            Toast.makeText(requireContext(),"Agregaste un pedido con éxito", Toast.LENGTH_SHORT).show()
        }else if(viewType == 2){
            appViewModel.updateOrder(orderCopy)
            findNavController().navigate(R.id.action_foodDetailFragment_to_cartFragment)
            Toast.makeText(requireContext(),"Actualizaste un pedido con éxito", Toast.LENGTH_SHORT).show()
        }else if(viewType == 3){
            appViewModel.createOrder(orderCopy)
            findNavController().navigate(R.id.action_foodDetailFragment_to_firstFragment)
            Toast.makeText(requireContext(),"Agregaste un pedido con éxito", Toast.LENGTH_SHORT).show()
        }

    }

}