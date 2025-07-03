package com.example.mimenu.ui.home

import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.data.Entities.VoucherEntity

interface OnClickHome {
    fun onClickDiscount(food: FoodEntity)
    fun onClickVoucher(voucher: VoucherEntity)
}