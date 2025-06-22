package com.example.mimenu.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.R
import com.example.mimenu.databinding.FragmentCartBinding
import com.example.mimenu.view_model.OrderViewModel


class CartFragment : Fragment(), OnOrderClick {

    private lateinit var binding: FragmentCartBinding
    private val orderViewModel by viewModels<OrderViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDataRecycler()
    }
    private fun setDataRecycler(){
        var orderList = orderViewModel.getAll()
        var adapter = CartAdapter(this)
        adapter.setOrderList(orderList)
        binding.rvCart.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCart.adapter = adapter
    }

    private fun setOrderMockeados(): List<OrderEntity>{
        val ordersList = listOf<OrderEntity>(
            OrderEntity(1,"Mega Doble Big Bang","Mega hamburguesa", 13900 ,  R.mipmap.hamburguer, 27800,2),
            OrderEntity(2,"Sundae de Frutilla","Sundae", 2900 ,  R.mipmap.sundae, 8700,3),
            OrderEntity(3,"Café con 2 Medialunas","2 medialunas de manteca acompañadas de un café", 2399,R.mipmap.coffe,  2399,1)
        )
        return  ordersList
    }

    override fun onClickEdit(order: OrderEntity) {
        TODO("Not yet implemented")
    }

    override fun onClickDelete(order: OrderEntity) {
        Toast.makeText(requireContext(), "Se elimino una orden con exito", Toast.LENGTH_LONG).show()
        orderViewModel.delete(order)
        setDataRecycler()
    }

    override fun onClickAdd(order: OrderEntity) {
        TODO("Not yet implemented")
    }

    override fun onClickSubtract(order: OrderEntity) {
        TODO("Not yet implemented")
    }


}