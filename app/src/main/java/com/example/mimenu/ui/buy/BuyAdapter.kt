package com.example.mimenu.ui.buy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mimenu.Entities.FoodEntity
import com.example.mimenu.databinding.FragmentItemBuyBinding

class BuyAdapter (private val listFood : List<FoodEntity>): RecyclerView.Adapter<BuyAdapter.BuyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FragmentItemBuyBinding.inflate(inflater,parent, false)
        return  BuyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuyViewHolder, position: Int) {
       val foodItem = listFood[position]
        holder.setValues(foodItem)
    }

    override fun getItemCount(): Int {
        return  listFood.size
    }

    class BuyViewHolder (private val binding : FragmentItemBuyBinding) : RecyclerView.ViewHolder(binding.root){
        fun setValues (food : FoodEntity){
            with(binding){
                tvNameItemBuy.text = food.name
                tvPriceItemBuy.text = "$ " +  food.price.toString()
            }
        }
    }

}