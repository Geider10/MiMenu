package com.example.mimenu.data

import androidx.lifecycle.LiveData
import com.example.mimenu.R
import com.example.mimenu.data.Entities.CategoryEntity
import com.example.mimenu.data.Entities.FoodEntity

abstract class DataProvider {
    companion object {
        fun getAllFood() : List<FoodEntity>{
            return foodList
        }
        fun getFoodOffer() : List<FoodEntity>{
            var foodFilter = foodList.filter { f -> f.discount != null }.subList(0,4)
            return  foodFilter
        }
        fun getAllCategory() : List<CategoryEntity>{
            return  categoryList
        }
        private val foodList : List<FoodEntity> = listOf(
            FoodEntity(1, "Doble Cuarto Xl" ,11900, "Mega hamburguesa de doble carne, doble queso cheddar, cebollita, kétchup y mostaza en pan de papa.", "Hamburguesa", R.mipmap.hamburguer),
            FoodEntity(2, "Epica Huevo" ,11300, "Mega hamburguesa de carne, queso cheddar, panceta, huevo, cebolla grillada y barbacoa ahumada en pan de papa.", "Hamburguesa", R.mipmap.hamburguer),
            FoodEntity(3, "Mega Doble Big Bang Cheddar" ,13900, "Mega hamburguesa de doble carne, queso cheddar, bacon, cebollita, kétchup y salsa cheddar en pan de papa. ", "Hamburguesa", R.mipmap.hamburguer, 40),
            FoodEntity(4, "Sundae de Chocalate" ,2900, "Helado de crema americana con salsa de chocolate.", "Sundae", R.mipmap.sundae, 20),
            FoodEntity(5, "Sundae de Frutilla" ,2900, "Helado de crema americana con salsa de frutilla.", "Sundae", R.mipmap.sundae),
            FoodEntity(6, "Sundae de Dulce de Leche" ,2900, "Helado de crema americana con salsa de dulce de leche.", "Sundae", R.mipmap.sundae),
            FoodEntity(7, "Café con 2 Medialunas" ,2399, "2 medialunas de manteca acompañadas de un café 330cc a elección o jugo de naranja." , "Team Dulce", R.mipmap.coffe),
            FoodEntity(8, "Medialuna" ,1000, "Medialuna de manteca." , "Team Dulce", R.mipmap.coffe),
            FoodEntity(9, "Café con 2 Medialunas de jamón y cheddar" ,3700, "2 medialunas jamón y cheddar de manteca acompañados de un café 330cc a elección o  jugo de naranja." , "Team Dulce", R.mipmap.coffe,5),
            FoodEntity(10, "Doble Cuarto Xl" ,11900, "Mega hamburguesa de doble carne, doble queso cheddar, cebollita, kétchup y mostaza en pan de papa.", "Hamburguesa", R.mipmap.hamburguer, 30),
            FoodEntity(11, "Sundae de Dulce de Leche" ,2900, "Helado de crema americana con salsa de dulce de leche.", "Sundae", R.mipmap.sundae,5),
            FoodEntity(12, "Sundae de Dulce de Leche" ,2900, "Helado de crema americana con salsa de dulce de leche.", "Sundae", R.mipmap.sundae,5)
            )
        private val categoryList : List<CategoryEntity> = listOf(
            CategoryEntity(1, "Hamburguesa"),
            CategoryEntity(2, "Sundae"),
            CategoryEntity(3, "Team Dulce"),
            CategoryEntity(4, "Ensaladas"),
            CategoryEntity(5, "Nuggets"),
            CategoryEntity(6, "bebidas"),
        )
    }

}