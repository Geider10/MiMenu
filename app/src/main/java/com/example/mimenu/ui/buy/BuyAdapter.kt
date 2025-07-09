package com.example.mimenu.ui.buy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mimenu.data.model.FoodModel
import com.example.mimenu.databinding.CategoryItemBuyBinding
import com.example.mimenu.databinding.FragmentItemBuyBinding
import com.example.mimenu.utils.AppUtil


const val CATEGORY = 0
const val FOOD = 1

class BuyAdapter (private val itemBuyList : List<ItemBuy>, private val buyFragment : SecondFragment): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val appUtil = AppUtil.getInstance()

    inner class CategoryViewHolder (private val binding : CategoryItemBuyBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindCategory(category : String){
            binding.tvCategoryItemBuy.text = category
        }
    }
    inner class FoodViewHolder (private val binding : FragmentItemBuyBinding) : RecyclerView.ViewHolder(binding.root){
        var priceFood = 0
        fun bindFood (food : FoodModel){
            if(food.discount != null) {
                val offer = (food.price * food.discount)/100
                val priceOffer = food.price - offer
                priceFood = priceOffer
                binding.tvPriceRemoveItemBuy.visibility = View.VISIBLE
                binding.tvDiscountItemBuy.visibility = View.VISIBLE
            }else{
                priceFood = food.price
                binding.tvPriceRemoveItemBuy.visibility = View.GONE
                binding.tvDiscountItemBuy.visibility = View.GONE
            }

            binding.tvNameItemBuy.text = food.name
            val priceRemove = appUtil.formatTextToStrikeThrough("$ ${food.price}")
            binding.tvPriceRemoveItemBuy.text = priceRemove
            binding.tvPriceItemBuy.text = "$ $priceFood"
            binding.tvDiscountItemBuy.text = "${food.discount}% OFF"
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
                holder.bindCategory(item.category)
            }
            is ItemBuy.FoodItem ->{
                var holder = holder as FoodViewHolder
                holder.bindFood(item.food)
            }
        }
    }

    override fun getItemCount(): Int = itemBuyList.size


}