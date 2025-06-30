package com.example.mimenu.ui.buy

import com.example.mimenu.data.Entities.CategoryEntity
import com.example.mimenu.data.Entities.FoodEntity
//modelo padre para disitintos objetos, pero comparten el mismo contenedor.
sealed class ItemBuy {
    data class CategoryItem(
        val id : Int,
        val name : String
    ) : ItemBuy()
    //entidad dentro de una clase local
    data class FoodItem(
        val food : FoodEntity
    ) : ItemBuy()
}