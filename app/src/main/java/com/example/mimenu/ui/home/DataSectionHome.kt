package com.example.mimenu.ui.home

import com.example.mimenu.data.model.FoodModel
import com.example.mimenu.data.model.VoucherModel

class DataSectionHome (
    val sectionType : Int,
    val foodOfferList : List<FoodModel> = emptyList(),
    val voucherList : List<VoucherModel> = emptyList()
        )