package com.example.mimenu.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.databinding.OrderItemCartBinding

class CartAdapter(private val listOrder : List<OrderEntity>, private val cartFragment : CartFragment) : RecyclerView.Adapter<CartAdapter.CartViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = OrderItemCartBinding.inflate(inflater,parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val orderItem = listOrder.get(position)
        holder.setValues(orderItem)
    }

    override fun getItemCount() : Int = listOrder.size

    inner class CartViewHolder(private val binding : OrderItemCartBinding) : RecyclerView.ViewHolder(binding.root){
        fun setValues(order : OrderEntity){
            binding.imgItemCart.setImageResource(order.img)
            binding.tvNameItemCart.text = order.name
            binding.tvQuantityItemCart.text = order.quantity.toString()
            binding.tvPriceItemCart.text ="$ " + order.priceTotal.toString()

            binding.tvEditOrderCart.setOnClickListener{
                cartFragment.onClickEdit(order)
            }
            binding.tvDeleteOrderCart.setOnClickListener{
                cartFragment.onClickDelete(order)
            }
            binding.btnAddOrder.setOnClickListener {
                cartFragment.onClickAdd(order)
            }
            binding.btnSubtractOrder.setOnClickListener {
                cartFragment.onClickSubtract(order)
            }
        }
    }

}