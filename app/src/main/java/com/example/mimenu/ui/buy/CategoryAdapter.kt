package com.example.mimenu.ui.buy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mimenu.data.Entities.CategoryEntity
import com.example.mimenu.databinding.CategoryItemBuyBinding

class CategoryAdapter (private val categoryList : List<CategoryEntity>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){

    inner class CategoryViewHolder(private val binding : CategoryItemBuyBinding) : RecyclerView.ViewHolder(binding.root){
        fun setValues(category : CategoryEntity){
            binding.tvCategoryItemBuy.text = category.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CategoryItemBuyBinding.inflate(inflater,parent, false)
        return  CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList.get(position)
        holder.setValues(category)
    }

    override fun getItemCount(): Int = categoryList.size

}