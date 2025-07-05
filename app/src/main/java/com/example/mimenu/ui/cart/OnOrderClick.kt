package com.example.mimenu.ui.cart

import com.example.mimenu.data.local.Entities.OrderEntity
import com.example.mimenu.data.model.OrderModel

interface OnOrderClick {
    fun onClickEdit(order : OrderModel)
    fun onClickDelete(order: OrderModel)
    fun onClickIcon(order: OrderModel)
}