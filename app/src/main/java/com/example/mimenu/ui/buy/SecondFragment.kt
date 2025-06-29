package com.example.mimenu.ui.buy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.R
import com.example.mimenu.data.Entities.CategoryEntity
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.databinding.FragmentSecondBinding
class SecondFragment : Fragment(), OnFoodClick {

    private lateinit var binding : FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerFood()
        setupRecyclerCategory()
    }
    private fun setupRecyclerFood(){
        var adapter = BuyAdapter(getFoodMock(),this)
        binding.rvFoodBuy.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFoodBuy.adapter = adapter
    }
    private fun getFoodMock() : List<FoodEntity>{
        val foodList : List<FoodEntity> = listOf(
            FoodEntity(1, "Doble Cuarto Xl" ,11900, "Mega hamburguesa de doble carne, doble queso cheddar, cebollita, kétchup y mostaza en pan de papa.", "Hamburguesa", R.mipmap.hamburguer),
            FoodEntity(2, "Epica Huevo" ,11300, "Mega hamburguesa de carne, queso cheddar, panceta, huevo, cebolla grillada y barbacoa ahumada en pan de papa.", "Hamburguesa", R.mipmap.hamburguer),
            FoodEntity(3, "Mega Doble Big Bang Cheddar" ,13900, "Mega hamburguesa de doble carne, queso cheddar, bacon, cebollita, kétchup y salsa cheddar en pan de papa. ", "Hamburguesa", R.mipmap.hamburguer),
            FoodEntity(4, "Sundae de Chocalate" ,2900, "Helado de crema americana con salsa de chocolate.", "Sundae", R.mipmap.sundae),
            FoodEntity(5, "Sundae de Frutilla" ,2900, "Helado de crema americana con salsa de frutilla.", "Sundae", R.mipmap.sundae),
            FoodEntity(6, "Sundae de Dulce de Leche" ,2900, "Helado de crema americana con salsa de dulce de leche.", "Sundae", R.mipmap.sundae),
            FoodEntity(7, "Café con 2 Medialunas" ,2399, "2 medialunas de manteca acompañadas de un café 330cc a elección o jugo de naranja." , "Team Dulce", R.mipmap.coffe),
            FoodEntity(8, "Medialuna" ,1000, "Medialuna de manteca." , "Team Dulce", R.mipmap.coffe),
            FoodEntity(9, "Café con 2 Medialunas de jamón y cheddar" ,3700, "2 medialunas jamón y cheddar de manteca acompañados de un café 330cc a elección o  jugo de naranja." , "Team Dulce", R.mipmap.coffe),
            )

        return foodList
    }

    override fun onClick(food: FoodEntity) {
        val order = OrderEntity(name = food.name, description = food.description, price = food.price, img = food.img, priceTotal = food.price, quantity = 1)
        val action = SecondFragmentDirections.actionSecondFragmentToFoodDetailFragment(order)
        findNavController().navigate(action)
    }

    private fun setupRecyclerCategory(){
        var adapter = CategoryAdapter(getCategoryMock())
        binding.rvCategoryBuy.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategoryBuy.adapter = adapter
    }
    private fun getCategoryMock(): List<CategoryEntity> {
        return listOf(
            CategoryEntity(1, "Hamburguesa"),
            CategoryEntity(2, "Sundae"),
            CategoryEntity(3, "Team Dulce"),
            CategoryEntity(4, "Ensaladas"),
            CategoryEntity(5, "Nuggets"),
            CategoryEntity(6, "bebidas"),
        )
    }
}