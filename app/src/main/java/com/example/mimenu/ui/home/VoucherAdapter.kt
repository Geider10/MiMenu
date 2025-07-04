package com.example.mimenu.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mimenu.data.Entities.VoucherEntity
import com.example.mimenu.data.model.VoucherModel
import com.example.mimenu.databinding.VoucherItemHomeBinding

class VoucherAdapter(private val voucherList : List<VoucherModel>, private val homeFragment: FirstFragment) : RecyclerView.Adapter<VoucherAdapter.VoucherViewHolder>() {
    inner class VoucherViewHolder(private val binding: VoucherItemHomeBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(voucher : VoucherModel){
            binding.ivVoucherHome.setBackgroundResource(voucher.img)

            binding.root.setOnClickListener{
                homeFragment.onClickVoucher(voucher)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoucherViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = VoucherItemHomeBinding.inflate(inflater)
        return  VoucherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VoucherViewHolder, position: Int) {
        val voucher = voucherList[position]
        holder.bind(voucher)
    }

    override fun getItemCount(): Int = voucherList.size
}