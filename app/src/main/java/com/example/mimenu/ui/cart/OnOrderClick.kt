package com.example.mimenu.ui.cart

import com.example.mimenu.data.Entities.OrderEntity

interface OnOrderClick {
    fun onClickEdit(order : OrderEntity)
    fun onClickDelete(order: OrderEntity)
    fun onClickIcon(order: OrderEntity)
}