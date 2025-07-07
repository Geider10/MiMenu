package com.example.mimenu.ui.cart

import android.annotation.SuppressLint
import android.graphics.Paint
import android.text.SpannableString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mimenu.data.local.Entities.OrderEntity
import com.example.mimenu.data.model.OrderModel
import com.example.mimenu.databinding.OrderItemCartBinding
import com.example.mimenu.utils.Util

class CartAdapter(private val cartFragment : CartFragment) : RecyclerView.Adapter<CartAdapter.CartViewHolder>(){

    private var orderList  = emptyList<OrderModel>()
    private val util = Util.getInstance()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = OrderItemCartBinding.inflate(inflater,parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val orderItem = orderList.get(position)
        holder.setValues(orderItem)
    }

    override fun getItemCount() : Int = orderList.size

    inner class CartViewHolder(private val binding : OrderItemCartBinding) : RecyclerView.ViewHolder(binding.root){
        var priceFood = 0
        fun setValues(order : OrderModel){
            if(order.discount != null){
                val offer = (order.price * order.discount) / 100
                priceFood = order.price - offer
                binding.tvPriceRemoveItemCart.visibility = View.VISIBLE
                binding.tvDiscountItemCart.visibility = View.VISIBLE
            }else {
                priceFood = order.price
                binding.tvPriceRemoveItemCart.visibility = View.GONE
                binding.tvDiscountItemCart.visibility = View.GONE
            }

            binding.imgItemCart.setImageResource(order.img)
            binding.tvNameItemCart.text = order.name
            binding.tvQuantityItemCart.text = order.quantity.toString()
            binding.tvPriceItemCart.text ="$ " + order.priceTotal.toString()
            binding.tvDiscountItemCart.text = "${order.discount}%"
            binding.tvPriceRemoveItemCart.text = setPriceRemove(order)

            binding.tvEditOrderCart.setOnClickListener{
                val quantity = binding.tvQuantityItemCart.text.toString().toInt()
                val priceTotal = priceFood * quantity
                val orderCopy = order.copy(priceTotal = priceTotal, quantity = quantity)

                cartFragment.onClickEdit(orderCopy)
            }
            binding.tvDeleteOrderCart.setOnClickListener{
                cartFragment.onClickDelete(order)
            }
            binding.btnAddOrder.setOnClickListener {
                var quantity = binding.tvQuantityItemCart.text.toString().toInt()
                quantity++
                val priceTotal = priceFood * quantity
                val orderCopy = order.copy(priceTotal = priceTotal, quantity = quantity)

                cartFragment.onClickIcon(orderCopy)
            }
            binding.btnSubtractOrder.setOnClickListener {
                var quantity = binding.tvQuantityItemCart.text.toString().toInt()
                if(quantity > 1){
                    quantity--
                    val priceTotal = priceFood * quantity
                    val orderCopy = order.copy(priceTotal = priceTotal, quantity = quantity)

                    cartFragment.onClickIcon(orderCopy)
                }
            }
        }
        private fun setPriceRemove(order : OrderModel) : SpannableString {
            val priceRemove = order.price * order.quantity
            return util.formatTextToStrikeThrough("$ $priceRemove")
        }
    }
    //@SuppressLint("NotifyDataSetChanged")
    fun setOrderList(orderList : List<OrderModel>){
        this.orderList = orderList
        //notifyDataSetChanged()
    }
    fun getPriceToPay(): Int{
        var total = 0
        for (order in orderList){
            total += order.priceTotal
        }
        return total
    }
}