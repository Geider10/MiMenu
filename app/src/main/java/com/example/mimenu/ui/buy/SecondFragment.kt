package com.example.mimenu.ui.buy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mimenu.Entities.FoodEntity
import com.example.mimenu.R
import com.example.mimenu.databinding.FragmentSecondBinding
class SecondFragment : Fragment() {

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
        val img = R.mipmap.hamburguer
        loadRecyclerView()
    }
    private fun loadRecyclerView(){
        binding.rvBuy.layoutManager = LinearLayoutManager(requireContext())
        binding.rvBuy.adapter = BuyAdapter(createFoodMock())
    }
    private fun createFoodMock() : List<FoodEntity>{
        val foodList : List<FoodEntity> = listOf(
            FoodEntity(1, "Doble Cuarto Xl" ,119000, "Mega hamburguesa", "Hamburguesa", R.mipmap.hamburguer),
            FoodEntity(2, "Epica Huevo" ,113000, "Mega hamburguesa", "Hamburguesa", R.mipmap.hamburguer),
            FoodEntity(3, "Mega Doble Big Bang" ,139000, "Mega hamburguesa", "Hamburguesa", R.mipmap.hamburguer),
            FoodEntity(4, "Sundae de Chocalate" ,2900, "Helado de crema americana", "Sundae", R.mipmap.sundae),
            FoodEntity(5, "Sundae de Frutilla" ,2900, "Helado de crema americana", "Sundae", R.mipmap.sundae),
            FoodEntity(6, "Sundae de Dulce de Leche" ,2900, "Helado de crema americana", "Sundae", R.mipmap.sundae),
            FoodEntity(7, "Café con 2 Medialunas" ,2399, "2 medialunas de manteca acompañadas de un café" , "Team Dulce", R.mipmap.coffe),
            FoodEntity(8, "Medialuna" ,1000, "medialunas de manteca" , "Team Dulce", R.mipmap.coffe),
            FoodEntity(9, "Café con 2 Medialunas de jamón y queso" ,2399, "2 medialunas y un café" , "Team Dulce", R.mipmap.coffe),
            )

        return foodList
    }

}