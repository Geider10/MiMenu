package com.example.mimenu.ui.buy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mimenu.R
import com.example.mimenu.data.model.FoodModel
import com.example.mimenu.data.model.OrderModel
import com.example.mimenu.databinding.FragmentSecondBinding
import com.example.mimenu.view_model.AppViewModel
import com.google.android.material.chip.Chip

class SecondFragment : Fragment(), OnFoodClick {

    private lateinit var binding : FragmentSecondBinding
    private val appViewModel by viewModels<AppViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupChipGroup(appViewModel.getAllCategories)
        setupRecyclerFood()
    }
    private fun setupRecyclerFood(){
        val itemBuyList = createItemBuyList()
        var adapter = BuyAdapter(itemBuyList,this)
        binding.rvFoodBuy.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFoodBuy.adapter = adapter
    }

    override fun onClick(food: FoodModel) {
        val order = OrderModel(name = food.name, description = food.description, price = food.price, img = food.img, priceTotal = food.price, quantity = 1, discount = food.discount)
        val action = SecondFragmentDirections.actionSecondFragmentToFoodDetailFragment(order,1)
        findNavController().navigate(action)
    }

    private fun setupChipGroup(categoryList : List<String>){
        categoryList.forEach{name   ->
            val chip = Chip(requireContext())
            chip.id = 1
            chip.text = name
            chip.isCheckable = true
            chip.isCheckedIconVisible = false
            chip.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_dark))
            chip.chipBackgroundColor = ContextCompat.getColorStateList(requireContext(), R.color.chip_category_selector)
            //if(tag.id == 1){
            //    chip.isChecked = true
            // }

            chip.setOnClickListener{
                Log.d("category-item", chip.text.toString())
            }
            binding.cgCategory.addView(chip)
        }
    }

    private fun createItemBuyList() : List<ItemBuy>{
        var itemBuyList = mutableListOf<ItemBuy>()
        val foodList = appViewModel.getAllFoods
        val categoryList = appViewModel.getAllCategories

        categoryList.forEach{ c ->
            itemBuyList.add(ItemBuy.CategoryItem(c))
            val foodFilter = foodList.filter { it.category == c }
            foodFilter.forEach{ f ->
                itemBuyList.add(ItemBuy.FoodItem(f))
            }
        }

        return  itemBuyList
    }

}