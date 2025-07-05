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
import com.example.mimenu.data.model.OrderModel
import com.example.mimenu.databinding.FragmentCartBinding
import com.example.mimenu.view_model.AppViewModel


class CartFragment : Fragment(), OnOrderClick {

    private lateinit var binding: FragmentCartBinding
    private val appViewModel by viewModels<AppViewModel>()
    
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
        appViewModel.getAllOrders.observe(viewLifecycleOwner){orderList ->
            var adapter = CartAdapter(this)
            adapter.setOrderList(orderList)
            binding.rvCart.layoutManager = LinearLayoutManager(requireContext())
            binding.rvCart.adapter = adapter

            var total = adapter.getPriceToPay()
            binding.tvPriceTotalCart.text = "$ $total"
        }

    }

    override fun onClickEdit(order: OrderModel) {
        val action = CartFragmentDirections.actionCartFragmentToFoodDetailFragment(order,2)
        findNavController().navigate(action)
    }
    override fun onClickDelete(order: OrderModel) {
        Toast.makeText(requireContext(), "Eliminaste un pedido con éxito", Toast.LENGTH_LONG).show()
        appViewModel.deleteOrder(order)
    }
    override fun onClickIcon(order: OrderModel) {
        appViewModel.updateOrder(order)
    }
    private fun onClickPay(){
        Toast.makeText(requireContext(), "Pagaste con éxito", Toast.LENGTH_SHORT).show()
    }
}