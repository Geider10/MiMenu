package com.example.mimenu.ui.buy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.R
import com.example.mimenu.data.Entities.CategoryEntity
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.databinding.FragmentItemBuyBinding
import com.example.mimenu.databinding.FragmentSecondBinding
import com.example.mimenu.view_model.CategoryViewModel
import com.example.mimenu.view_model.FoodViewModel
import com.google.android.material.chip.Chip

class SecondFragment : Fragment(), OnFoodClick {

    private lateinit var binding : FragmentSecondBinding
    private val foodViewModel by viewModels<FoodViewModel>()
    private val categoryViewModel by viewModels<CategoryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupChipGroup(categoryViewModel.getAll)
        setupRecyclerFood()
    }
    private fun setupRecyclerFood(){
        val itemBuyList = createItemBuyList()
        var adapter = BuyAdapter(itemBuyList,this)
        binding.rvFoodBuy.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFoodBuy.adapter = adapter
    }

    override fun onClick(food: FoodEntity) {
        val order = OrderEntity(name = food.name, description = food.description, price = food.price, img = food.img, priceTotal = food.price, quantity = 1, discount = food.discount)
        val action = SecondFragmentDirections.actionSecondFragmentToFoodDetailFragment(order,1)
        findNavController().navigate(action)
    }

    private fun setupChipGroup(categoryList : List<CategoryEntity>){
        categoryList.forEach{ tag ->
            val chip = Chip(requireContext())
            chip.text = tag.name
            chip.isCheckable = true
            chip.isCheckedIconVisible = false
            chip.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_dark))
            chip.chipBackgroundColor = ContextCompat.getColorStateList(requireContext(), R.color.chip_category_selector)
            if(tag.id == 1){
                chip.isChecked = true
            }

            chip.setOnClickListener{
                Log.d("category-item", chip.text.toString())
            }
            binding.cgCategory.addView(chip)
        }
    }

    private fun createItemBuyList() : List<ItemBuy>{
        var itemBuyList = mutableListOf<ItemBuy>()//cada item es un categoryItem o foodItem
        val foodList = foodViewModel.getAll
        val categoryList = categoryViewModel.getAll

        categoryList.forEach{ c ->
            itemBuyList.add(ItemBuy.CategoryItem(c.id,c.name))
            val foodFilter = foodList.filter { it.category == c.name }
            foodFilter.forEach{ f ->
                itemBuyList.add(ItemBuy.FoodItem(f))
            }
        }

        return  itemBuyList
    }

}