package com.example.mimenu.ui.buy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mimenu.data.Entities.CategoryEntity
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.databinding.CategoryItemBuyBinding
import com.example.mimenu.databinding.FragmentItemBuyBinding


const val CATEGORY = 0
const val FOOD = 1

class BuyAdapter (private val itemBuyList : List<ItemBuy>, private val buyFragment : SecondFragment): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    inner class CategoryViewHolder (private val binding : CategoryItemBuyBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindCategory(category : CategoryEntity){
            binding.tvCategoryItemBuy.text = category.name
        }
    }
    inner class FoodViewHolder (private val binding : FragmentItemBuyBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindFood (food : FoodEntity){
            binding.tvNameItemBuy.text = food.name
            binding.tvPriceItemBuy.text = "$ " + food.price.toString()
            binding.imgItemBuy.setImageResource(food.img)

            binding.root.setOnClickListener{
                buyFragment.onClick(food)
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        return when(itemBuyList[position]){
            is ItemBuy.CategoryItem -> CATEGORY
            is ItemBuy.FoodItem -> FOOD
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if (viewType == CATEGORY){
            val binding = CategoryItemBuyBinding.inflate(inflater,parent, false)
            return CategoryViewHolder(binding)
        }
        else{
            val binding = FragmentItemBuyBinding.inflate(inflater,parent, false)
            return  FoodViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(val item = itemBuyList[position]){
            is ItemBuy.CategoryItem ->{
                var holder = holder as CategoryViewHolder
                holder.bindCategory(CategoryEntity(item.id,item.name))
            }
            is ItemBuy.FoodItem ->{
                var holder = holder as FoodViewHolder
                holder.bindFood(item.food)
            }
        }
    }

    override fun getItemCount(): Int = itemBuyList.size


}