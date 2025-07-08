package com.example.mimenu.data.mock

import com.example.mimenu.R
import com.example.mimenu.data.model.FoodModel
import com.example.mimenu.data.model.VoucherModel
import java.time.LocalDate

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
             FoodModel(10,"Nuggets X6", 8700, "6 bocaditos de pechuga de pollo, acompañadas de papas fritas y bebida a elección.", "Nuggets", R.mipmap.nuggets),
             FoodModel(11,"Nuggets bacon y cheddar x10", 12900, "10 bocaditos de pechuga de pollo bañados en muuucho cheddar y trocitos de bacon, acompañadas de papas fritas y bebida a elección.", "Nuggets", R.mipmap.nuggets),
             FoodModel(12,"Balde de Nuggets", 16500, "Balde con 30 bocaditos de pechuga de pollo.", "Nuggets", R.mipmap.nuggets,35),
             FoodModel(13, "Sandwich Huevo & Palta" ,8500, "Sandwich con doble huevo, palta y mayonesa, acompañado de papas fritas regulares y una bebida a elección", "Menúes Veggies", R.mipmap.ensalada),
             FoodModel(14, "Ensalada Palta y Egg Veggie" ,11900, "Ensalada con tomate, lechuga, cebolla grillada, huevo y palta, acompañada de una bebida a elección", "Menúes Veggies", R.mipmap.ensalada,20),
             FoodModel(15, "Cerro Veggie" ,8900, "Hamburguesa 100% a base de plantas con lechuga, tomate, cebolla, pepino, mostaza y kétchup.", "Menúes Veggies", R.mipmap.ensalada),
             )
         val categoryList : List<String> = listOf(
            "Hamburguesa",
            "Sundae",
            "Team Dulce",
            "Menúes Veggies",
            "Nuggets"
         )
         val bannerList : List<Int> = listOf(
             R.mipmap.banner1,
             R.mipmap.banner2,
             R.mipmap.banner3,
             R.mipmap.banner4,
             R.mipmap.banner5
        )
        val voucherList: List<VoucherModel> = listOf(
            VoucherModel(1, "Combo Mega Doble Big Bang + Sundae",
                "Pedí la Mega Doble Big Bang y te llevás un Sundae gratis. Mega Doble Big Bang: Mega hamburguesa de doble carne, queso cheddar, bacon, cebollita, kétchup y salsa cheddar en pan de papa. Sundae: Helado de crema americana con salsa de chocolate.",
                R.mipmap.voucher1, "54-2353-1646", LocalDate.of(2025, 8, 10), "Las + poderosas"),
            VoucherModel(6, "Sundae x3 Pack",
                "Elegí 3 sundaes a elección por $6900. Sundae: Helado de crema americana con salsa a elección.",
                R.mipmap.voucher4, "66-3939-1029", LocalDate.of(2025, 10, 20), "Para compartir"),
            VoucherModel(5, "Ensalada y Sandwich de palta",
                "2 medialunas rellenas + 2 cafés. Compartí una mañana feliz. Ensalada: Ensalada con tomate, lechuga, cebolla grillada, huevo y palta, acompañada de una bebida a elección. Sandwich de palta: Sandwich con doble huevo, palta y mayonesa, acompañado de papas fritas regulares y una bebida a elección.",
                R.mipmap.voucher3, "84-9247-1172", LocalDate.of(2025, 9, 20), "Para compartir"),
            VoucherModel(3, "Big Bang Cheddar + Nuggets",
                "El duo legendario con 40% de descuento. Big Bang Cheddar: Mega hamburguesa de doble carne, queso cheddar, bacon, cebollita, kétchup y salsa cheddar en pan de papa. Nuggets: 6 bocaditos de pechuga de pollo, acompañadas de papas fritas y bebida a elección.",
                R.mipmap.voucher2, "61-9294-3847", LocalDate.of(2025, 8, 20), "Las + poderosas"),
            VoucherModel(2, "Epica Huevo + Cuarto XL",
                "35% OFF solo por tiempo limitado. Epica huevo: Mega hamburguesa de carne, queso cheddar, panceta, huevo, cebolla grillada y barbacoa ahumada en pan de papa. Doble Cuarto XL: Mega hamburguesa de doble carne, doble queso cheddar, cebollita, kétchup y mostaza en pan de papa.",
                R.mipmap.voucher1, "78-8472-1023", LocalDate.of(2025, 8, 15), "Las + poderosas"),
            VoucherModel(4, "x2 Nuggets con Bacon y Cheddar",
                "Ideal para dos solo $22000. Nuggets con Bacon y Cheddar: 10 bocaditos de pechuga de pollo bañados en muuucho cheddar y trocitos de bacon, acompañadas de papas fritas y bebida a elección.",
                R.mipmap.voucher2, "73-1846-5821", LocalDate.of(2025, 9, 10), "Para compartir"),
            VoucherModel(7, "6 medialunas + 2 cafè",
                "Solo por $6000 con 25% de descuento. Medialuna: de manteca. Café express.",
                R.mipmap.voucher3, "35-4821-3991", LocalDate.of(2025, 10, 27), "Algo dulce"),
            VoucherModel(8, "Sundae + 2 medialunas",
                "Helado y 2 medialunas por solo $4000. Sundae: Helado de crema americana con salsa a elección. Medialuna: de manteca.",
                R.mipmap.voucher4, "49-2783-8872", LocalDate.of(2025, 9, 18), "Algo dulce"),
            VoucherModel(9, "Café con medialuna gratis",
                "Comprás un café y te llevás una medialuna sin costo solo por $2000. Café: express. Medialuna: de manteca.",
                R.mipmap.voucher3, "58-3021-0042", LocalDate.of(2025, 9, 25), "Algo dulce")
        )
    }
}