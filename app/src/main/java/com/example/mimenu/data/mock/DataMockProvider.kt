package com.example.mimenu.data.mock

import com.example.mimenu.R
import com.example.mimenu.data.Entities.BannerEntity
import com.example.mimenu.data.Entities.CategoryEntity
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.data.model.VoucherModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

abstract class DataMockProvider {

    companion object {
        fun getAllFood() : List<FoodEntity>{
            return foodList
        }
        fun getFoodOffer() : List<FoodEntity>{
            var foodFilter = foodList.filter { f -> f.discount != null }.subList(0,4)
            return  foodFilter
        }
        fun getAllCategories() : List<String>{
            return  categoryList
        }
        fun getAllBanners() : List<Int>{
            return  bannerList
        }
        fun getAllVouchers () : List<VoucherModel> {
            return  voucherList
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
            )
        private val categoryList : List<String> = listOf(
            "Hamburguesa",
            "Sundae",
            "Team Dulce",
            "Ensaladas",
            "Nuggets",
            "bebidas"
        )
        private val bannerList : List<Int> = listOf(
            R.mipmap.b44,
            R.mipmap.b2,
            R.mipmap.b33,
            R.mipmap.b1
        )
        private fun stringToLocalDate(date : String) : LocalDate {
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyy")
            return LocalDate.parse(date,formatter)
        }
        private val voucherList : List<VoucherModel> = listOf(
            VoucherModel(
                id = 1,
                name = "Combo Mega Doble Big Bang + Sundae",
                description = "Pedí la Mega Doble Big Bang y te llevás un Sundae gratis. Ideal para campeones del hambre.",
                img = R.mipmap.co2,
                code = "54-2353-1646",
                expiration = stringToLocalDate("10/08/2025"),
                category = "Las + poderosas"
            ),
            VoucherModel(
                id = 2,
                name = "Epica Huevo + Cuarto XL",
                description = "Combo de poder con dos hamburguesas icónicas. 35% OFF solo por tiempo limitado.",
                img = R.mipmap.co2,
                code = "78-8472-1023",
                expiration = stringToLocalDate("15/08/2025"),
                category = "Las + poderosas"
            ),
            VoucherModel(
                id = 3,
                name = "Big Bang Cheddar + Bebida + Sundae",
                description = "El trío legendario con 40% de descuento. ¿Vas a resistirte?",
                img = R.mipmap.co1,
                code = "61-9294-3847",
                expiration = stringToLocalDate("20/08/2025"),
                category = "Las + poderosas"
            ),
            VoucherModel(
                id = 4,
                name = "2 Combos Doble Cuarto XL",
                description = "Ideal para dos. Incluye 2 hamburguesas, 2 papas y 2 bebidas. A solo $14500.",
                img = R.mipmap.co1,
                code = "73-1846-5821",
                expiration = stringToLocalDate("10/09/2025"),
                category = "Para compartir"
            ),
            VoucherModel(
                id = 5,
                name = "Combo Dulce x2 + Café",
                description = "2 medialunas rellenas + 2 cafés. Compartí una mañana feliz.",
                img = R.mipmap.h3,
                code = "84-9247-1172",
                expiration = stringToLocalDate("10/09/2025"),
                category = "Para compartir"
            ),
            VoucherModel(
                id = 6,
                name = "Sundae x3 Pack",
                description = "El pack perfecto para amigos dulceros. Elegí 3 sundaes a elección por $6900.",
                img = R.mipmap.h1,
                code = "66-3939-1029",
                expiration = stringToLocalDate("20/10/2025"),
                category = "Para compartir"
            ),
            VoucherModel(
                id = 7,
                name = "Café + 2 Medialunas rellenas",
                description = "Combo especial dulce por la tarde. Con 15% de descuento.",
                img = R.mipmap.h3,
                code = "35-4821-3991",
                expiration = stringToLocalDate("12/09/2025"),
                category = "Algo dulce"
            ),
            VoucherModel(
                id = 8,
                name = "Sundae + Medialuna",
                description = "¿Dulce sobre dulce? Helado y medialuna por solo $3100.",
                img = R.mipmap.h1,
                code = "49-2783-8872",
                expiration = stringToLocalDate("18/09/2025"),
                category = "Algo dulce"
            ),
            VoucherModel(
                id = 9,
                name = "Café con medialuna gratis",
                description = "Comprás un café y te llevás una medialuna sin costo. Porque sí.",
                img = R.mipmap.h3,
                code = "58-3021-0042",
                expiration = stringToLocalDate("25/09/2025"),
                category = "Algo dulce"
            )
        )

    }
}
