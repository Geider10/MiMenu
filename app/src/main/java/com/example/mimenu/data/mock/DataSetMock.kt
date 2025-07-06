package com.example.mimenu.data.mock

import com.example.mimenu.R
import com.example.mimenu.data.model.FoodModel
import com.example.mimenu.data.model.VoucherModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

abstract class DataSetMock {
    companion object{

         val foodList : List<FoodModel> = listOf(
             FoodModel(1, "Doble Cuarto Xl" ,12300, "Mega hamburguesa de doble carne, doble queso cheddar, cebollita, kétchup y mostaza en pan de papa.", "Hamburguesa", R.mipmap.hamburguer),
             FoodModel(2, "Epica Huevo" ,11900, "Mega hamburguesa de carne, queso cheddar, panceta, huevo, cebolla grillada y barbacoa ahumada en pan de papa.", "Hamburguesa", R.mipmap.hamburguer),
             FoodModel(3, "Mega Doble Big Bang Cheddar" ,14300, "Mega hamburguesa de doble carne, queso cheddar, bacon, cebollita, kétchup y salsa cheddar en pan de papa. ", "Hamburguesa", R.mipmap.hamburguer, 40),
             FoodModel(4, "Sundae de Chocalate" ,2900, "Helado de crema americana con salsa de chocolate.", "Sundae", R.mipmap.sundae, 20),
             FoodModel(5, "Sundae de Frutilla" ,2900, "Helado de crema americana con salsa de frutilla.", "Sundae", R.mipmap.sundae),
             FoodModel(6, "Sundae de Dulce de Leche" ,2900, "Helado de crema americana con salsa de dulce de leche.", "Sundae", R.mipmap.sundae),
             FoodModel(7, "Café con 2 Medialunas" ,2400, "2 medialunas de manteca acompañadas de un café 330cc a elección o jugo de naranja." , "Team Dulce", R.mipmap.coffe),
             FoodModel(8, "Medialuna" ,1000, "Medialuna de manteca." , "Team Dulce", R.mipmap.coffe),
             FoodModel(9, "Café con 2 Medialunas de jamón y cheddar" ,3700, "2 medialunas jamón y cheddar de manteca acompañados de un café 330cc a elección o  jugo de naranja." , "Team Dulce", R.mipmap.coffe,5),
             FoodModel(10,"Nuggets X6", 8700, "6 bocaditos de pechuga de pollo, acompañadas de papas fritas y bebida a elección.", "Nuggets", R.mipmap.hamburguer),
             FoodModel(11,"Nuggets bacon y cheddar x10", 12900, "10 bocaditos de pechuga de pollo bañados en muuucho cheddar y trocitos de bacon, acompañadas de papas fritas y bebida a elección.", "Nuggets", R.mipmap.hamburguer),
             FoodModel(12,"Balde de Nuggets", 16500, "Balde con 30 bocaditos de pechuga de pollo.", "Nuggets", R.mipmap.hamburguer,35),
             FoodModel(13, "Sandwich Huevo & Palta" ,8500, "Sandwich con doble huevo, palta y mayonesa, acompañado de papas fritas regulares y una bebida a elección", "Menúes Veggies", R.mipmap.hamburguer),
             FoodModel(14, "Ensalada Palta y Egg Veggie" ,11900, "Ensalada con tomate, lechuga, cebolla grillada, huevo y palta, acompañada de una bebida a elección", "Menúes Veggies", R.mipmap.hamburguer,20),
             FoodModel(15, "Cerro Veggie" ,8900, "Hamburguesa 100% a base de plantas con lechuga, tomate, cebolla, pepino, mostaza y kétchup.", "Menúes Veggies", R.mipmap.hamburguer),

             )
         val categoryList : List<String> = listOf(
            "Hamburguesa",
            "Sundae",
            "Team Dulce",
            "Menúes Veggies",
            "Nuggets"
         )
         val bannerList : List<Int> = listOf(
            R.mipmap.b44,
            R.mipmap.b2,
            R.mipmap.b33,
            R.mipmap.b1
        )

         val voucherList : List<VoucherModel> = listOf(
            VoucherModel(
                id = 1,
                name = "Combo Mega Doble Big Bang + Sundae",
                description = "Pedí la Mega Doble Big Bang y te llevás un Sundae gratis. Ideal para campeones del hambre.",
                img = R.mipmap.co2,
                code = "54-2353-1646",
                expiration = LocalDate.of(2025,8,10),
                category = "Las + poderosas"
            ),
            VoucherModel(
                id = 2,
                name = "Epica Huevo + Cuarto XL",
                description = "Combo de poder con dos hamburguesas icónicas. 35% OFF solo por tiempo limitado.",
                img = R.mipmap.co2,
                code = "78-8472-1023",
                expiration = LocalDate.of(2025,8,15),
                category = "Las + poderosas"
            ),
            VoucherModel(
                id = 3,
                name = "Big Bang Cheddar + Bebida + Sundae",
                description = "El trío legendario con 40% de descuento. ¿Vas a resistirte?",
                img = R.mipmap.co1,
                code = "61-9294-3847",
                expiration = LocalDate.of(2025,8,20),
                category = "Las + poderosas"
            ),
            VoucherModel(
                id = 4,
                name = "2 Combos Doble Cuarto XL",
                description = "Ideal para dos. Incluye 2 hamburguesas, 2 papas y 2 bebidas. A solo $14500.",
                img = R.mipmap.co1,
                code = "73-1846-5821",
                expiration = LocalDate.of(2025,9,10),
                category = "Para compartir"
            ),
            VoucherModel(
                id = 5,
                name = "Combo Dulce x2 + Café",
                description = "2 medialunas rellenas + 2 cafés. Compartí una mañana feliz.",
                img = R.mipmap.h3,
                code = "84-9247-1172",
                expiration =  LocalDate.of(2025,9,20),
                category = "Para compartir"
            ),
            VoucherModel(
                id = 6,
                name = "Sundae x3 Pack",
                description = "El pack perfecto para amigos dulceros. Elegí 3 sundaes a elección por $6900.",
                img = R.mipmap.h1,
                code = "66-3939-1029",
                expiration =  LocalDate.of(2025,10,20),
                category = "Para compartir"
            ),
            VoucherModel(
                id = 7,
                name = "Café + 2 Medialunas rellenas",
                description = "Combo especial dulce por la tarde. Con 15% de descuento.",
                img = R.mipmap.h3,
                code = "35-4821-3991",
                expiration =  LocalDate.of(2025,10,27),
                category = "Algo dulce"
            ),
            VoucherModel(
                id = 8,
                name = "Sundae + Medialuna",
                description = "¿Dulce sobre dulce? Helado y medialuna por solo $3100.",
                img = R.mipmap.h1,
                code = "49-2783-8872",
                expiration = LocalDate.of(2025,9,18),
                category = "Algo dulce"
            ),
            VoucherModel(
                id = 9,
                name = "Café con medialuna gratis",
                description = "Comprás un café y te llevás una medialuna sin costo. Porque sí.",
                img = R.mipmap.h3,
                code = "58-3021-0042",
                expiration =  LocalDate.of(2025,9,25),
                category = "Algo dulce"
            )
        )

    }
}