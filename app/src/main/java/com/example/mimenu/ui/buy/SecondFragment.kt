package com.example.mimenu.ui.buy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.R
import com.example.mimenu.data.Entities.CategoryEntity
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.databinding.FragmentItemBuyBinding
import com.example.mimenu.databinding.FragmentSecondBinding
import com.google.android.material.chip.Chip

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

        setupChipGroup(getCategoryMock())
        setupRecyclerFood()
    }
    private fun setupRecyclerFood(){
        val itemBuyList = createItemBuyList()
        var adapter = BuyAdapter(itemBuyList,this)
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

    private fun setupChipGroup(categoryList : List<CategoryEntity>){
        categoryList.forEach{ tag ->
            val chip = Chip(requireContext())
            chip.text = tag.name
            chip.isCheckable = true
            chip.isCheckedIconVisible = false
            chip.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_dark))
            chip.chipBackgroundColor = ContextCompat.getColorStateList(requireContext(), R.color.chip_category_selector)
            if(tag.id == 1){
                chip.isChecked = true
            }

            chip.setOnClickListener{
                Log.d("category-item", chip.text.toString())
            }
            binding.cgCategory.addView(chip)
        }
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

    private fun createItemBuyList() : List<ItemBuy>{
        var itemBuyList = mutableListOf<ItemBuy>()//cada item es un categoryItem o foodItem
        val foodList = getFoodMock()
        val categoryList = getCategoryMock()

        categoryList.forEach{ c ->
            itemBuyList.add(ItemBuy.CategoryItem(c.id,c.name))
            val foodFilter = foodList.filter { it.category == c.name }
            foodFilter.forEach{ f ->
                itemBuyList.add(ItemBuy.FoodItem(f))
            }
        }

        return  itemBuyList
    }

}