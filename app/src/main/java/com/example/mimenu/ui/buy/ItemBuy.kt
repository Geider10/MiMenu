package com.example.mimenu.ui.buy

import com.example.mimenu.data.Entities.CategoryEntity
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.data.model.FoodModel

//modelo padre para disitintos objetos, pero comparten el mismo contenedor.
sealed class ItemBuy {
    data class CategoryItem(
        val category : String
    ) : ItemBuy()

    data class FoodItem(
        val food : FoodModel
    ) : ItemBuy()
}
