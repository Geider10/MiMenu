package com.example.mimenu.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.databinding.FoodDiscountHomeBinding

class DiscountAdapter(private val discountList : List<FoodEntity>, private val homeFragment: FirstFragment): RecyclerView.Adapter<DiscountAdapter.DiscountViewHolder>() {
    inner class DiscountViewHolder(private val binding : FoodDiscountHomeBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(food : FoodEntity){
            val offer =(food.price * food.discount!!) / 100
            val priceOffer = food.price - offer
            binding.ivFDHome.setImageResource(food.img)
            binding.tvNameFDHome.text = food.name
            binding.tvPriceFDHome.text = "$ ${food.price}"
            binding.tvDiscountFDHome.text = "${food.discount}% OFF"
            binding.tvPriceOfferFDHome.text = "$ $priceOffer"

            binding.root.setOnClickListener{
                homeFragment.onClickDiscount(food)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FoodDiscountHomeBinding.inflate(inflater)
        return DiscountViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DiscountViewHolder, position: Int) {
        val item = discountList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = discountList.size

}