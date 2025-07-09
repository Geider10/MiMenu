package com.example.mimenu.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mimenu.data.model.FoodModel
import com.example.mimenu.data.model.VoucherModel
import com.example.mimenu.databinding.CarruselSectionHomeBinding

class MainAdapter(private val dataSectionList : List<DataSectionHome>, private val homeFragment: FirstFragment) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class FoodSectionViewHolder(private val binding : CarruselSectionHomeBinding) : RecyclerView.ViewHolder(binding.root){
        fun foodBind(foodList : List<FoodModel>){
            val adapter = DiscountAdapter(foodList,homeFragment)
            binding.tvTitleCarruselHome.text = "Descuentos"
            binding.rvCarruselSectionHome.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
            binding.rvCarruselSectionHome.adapter = adapter
        }
    }
    inner class VoucherSectionViewHolder(private val binding : CarruselSectionHomeBinding) : RecyclerView.ViewHolder(binding.root){
        fun voucherBind(voucherList : List<VoucherModel>){
            val adapter = VoucherAdapter(voucherList,homeFragment)
            binding.tvTitleCarruselHome.text = "Cupónes"
            binding.rvCarruselSectionHome.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL,false)
            binding.rvCarruselSectionHome.adapter = adapter
        }
    }

    override fun getItemViewType(position: Int): Int {
        return dataSectionList[position].sectionType
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if(viewType == 1){
            val binding = CarruselSectionHomeBinding.inflate(inflater,parent,false)
            return VoucherSectionViewHolder(binding)
        }else{
            val binding = CarruselSectionHomeBinding.inflate(inflater,parent,false)
            return FoodSectionViewHolder(binding)
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val dataList = dataSectionList[position]
       when(holder){
           is VoucherSectionViewHolder -> holder.voucherBind(dataList.voucherList)
           is FoodSectionViewHolder -> holder.foodBind(dataList.foodOfferList)
       }
    }
    override fun getItemCount(): Int = dataSectionList.size
}