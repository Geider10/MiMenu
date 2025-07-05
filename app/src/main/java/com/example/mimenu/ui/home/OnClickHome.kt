package com.example.mimenu.ui.home

import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.data.Entities.VoucherEntity
import com.example.mimenu.data.model.FoodModel
import com.example.mimenu.data.model.VoucherModel

interface OnClickHome {
    fun onClickDiscount(food: FoodModel)
    fun onClickVoucher(voucher: VoucherModel)
}