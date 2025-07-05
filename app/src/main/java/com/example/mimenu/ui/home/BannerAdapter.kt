package com.example.mimenu.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mimenu.databinding.BannerItemHomeBinding

class BannerAdapter (private var bannerList : List<Int>) : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>(){
    inner class BannerViewHolder(private val binding : BannerItemHomeBinding):RecyclerView.ViewHolder(binding.root){
        fun setValues(banner : Int){
            binding.imgBannerHome.setBackgroundResource(banner)
        }
    }
    //infla el layout de los elementos de la lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BannerItemHomeBinding.inflate(inflater,parent, false)
        return  BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val banner = bannerList.get(position)
        holder.setValues(banner)
    }

    override fun getItemCount(): Int = bannerList.size

}