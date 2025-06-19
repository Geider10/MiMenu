package com.example.mimenu.ui.buy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.databinding.FragmentItemBuyBinding


class BuyAdapter (private val listFood : List<FoodEntity>, private val buyFragment : SecondFragment): RecyclerView.Adapter<BuyAdapter.BuyViewHolder>(){

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

    inner class BuyViewHolder (private val binding : FragmentItemBuyBinding) : RecyclerView.ViewHolder(binding.root){
        fun setValues (food : FoodEntity){

            binding.tvNameItemBuy.text = food.name
            binding.tvPriceItemBuy.text = "$ " + food.price.toString()
            binding.imgItemBuy.setImageResource(food.img)

            binding.root.setOnClickListener{
               buyFragment.onClick(food)
            }
        }

    }

}