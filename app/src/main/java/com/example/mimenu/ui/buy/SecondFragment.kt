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
import androidx.recyclerview.widget.RecyclerView
import com.example.mimenu.R
import com.example.mimenu.data.model.FoodModel
import com.example.mimenu.data.model.OrderModel
import com.example.mimenu.databinding.FragmentSecondBinding
import com.example.mimenu.view_model.AppViewModel
import com.google.android.material.chip.Chip
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab

class SecondFragment : Fragment(), OnFoodClick {

    private lateinit var binding : FragmentSecondBinding
    private lateinit var tabLayout : TabLayout
    private lateinit var recyclerView: RecyclerView
    private  lateinit var itemList : List<ItemBuy>
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

        itemList = createItemBuyList()
        setupTabLayout(itemList)
        setupRecyclerFood(itemList)
    }
    override fun onClick(food: FoodModel) {
        val order = OrderModel(name = food.name, description = food.description, price = food.price, img = food.img, priceTotal = food.price, quantity = 1, discount = food.discount)
        val action = SecondFragmentDirections.actionSecondFragmentToFoodDetailFragment(order,1)
        findNavController().navigate(action)
    }
    private fun setupRecyclerFood(itemList : List<ItemBuy>){
        var adapter = BuyAdapter(itemList,this)
        recyclerView = binding.rvFoodBuy
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
    private fun setupTabLayout(itemList : List<ItemBuy>){
        tabLayout = binding.tlCategoryFoodBuy
        val categoryList : List<String> = appViewModel.getAllCategories
        categoryList.forEach{name   ->
            var tab= tabLayout.newTab()
            tab.setText(name)
            binding.tlCategoryFoodBuy.addTab(tab)
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: Tab?) {
                val categoryValue = tab?.text.toString()
                Log.i("Buy Fragment", "selet tab : $categoryValue")
                val categoryIndex = itemList.indexOfFirst{ c -> c is ItemBuy.CategoryItem && c.category == categoryValue }

                if(categoryIndex != -1){
                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                    layoutManager.scrollToPositionWithOffset(categoryIndex, 0) // 0 = top
                }
            }

            override fun onTabUnselected(tab: Tab?) {
            }

            override fun onTabReselected(tab: Tab?) {
            }

        })
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