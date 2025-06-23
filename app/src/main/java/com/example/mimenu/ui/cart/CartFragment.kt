package com.example.mimenu.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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
        binding.btnPayCart.setOnClickListener{
            onClickPay()
        }
    }
    private fun setDataRecycler(){
        var orderList = orderViewModel.getAll()
        var adapter = CartAdapter(this)
        adapter.setOrderList(orderList)
        var total = adapter.getPriceToPay()
        binding.rvCart.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCart.adapter = adapter
        binding.tvPriceTotalCart.text = "$ $total"
    }

    override fun onClickEdit(order: OrderEntity) {
        val action = CartFragmentDirections.actionCartFragmentToFoodDetailFragment(order)
        findNavController().navigate(action)
    }

    override fun onClickDelete(order: OrderEntity) {
        Toast.makeText(requireContext(), "Eliminaste un pedido con éxito", Toast.LENGTH_LONG).show()
        orderViewModel.delete(order)
        setDataRecycler()
    }

    override fun onClickIcon(order: OrderEntity) {
        orderViewModel.update(order)
        setDataRecycler()
    }
    private fun onClickPay(){
        Toast.makeText(requireContext(), "Pagaste con éxito", Toast.LENGTH_SHORT).show()
    }
}