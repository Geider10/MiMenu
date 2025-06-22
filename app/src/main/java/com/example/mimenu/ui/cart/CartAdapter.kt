package com.example.mimenu.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.databinding.OrderItemCartBinding

class CartAdapter(private val cartFragment : CartFragment) : RecyclerView.Adapter<CartAdapter.CartViewHolder>(){

    private var orderList  = emptyList<OrderEntity>()

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
        fun setValues(order : OrderEntity){
            binding.imgItemCart.setImageResource(order.img)
            binding.tvNameItemCart.text = order.name
            binding.tvQuantityItemCart.text = order.quantity.toString()
            binding.tvPriceItemCart.text ="$ " + order.priceTotal.toString()

            binding.tvEditOrderCart.setOnClickListener{
                var pricetotal = binding.tvPriceItemCart.text.toString()
                val quantity = binding.tvQuantityItemCart.text.toString()
                pricetotal = pricetotal.substring(2)
                val orderCopy = order.copy(priceTotal = pricetotal.toInt(), quantity = quantity.toInt())

                cartFragment.onClickEdit(orderCopy)
            }
            binding.tvDeleteOrderCart.setOnClickListener{
                cartFragment.onClickDelete(order)
            }
            binding.btnAddOrder.setOnClickListener {
                var quantity = binding.tvQuantityItemCart.text.toString().toInt()
                quantity++
                val priceTotal = order.price * quantity
                val orderCopy = order.copy(priceTotal = priceTotal, quantity = quantity)

                cartFragment.onClickIcon(orderCopy)
            }
            binding.btnSubtractOrder.setOnClickListener {
                var quantity = binding.tvQuantityItemCart.text.toString().toInt()
                if(quantity > 1){
                    quantity--
                    val priceTotal = order.price * quantity
                    val orderCopy = order.copy(priceTotal = priceTotal, quantity = quantity)

                    cartFragment.onClickIcon(orderCopy)
                }
            }
        }
    }
    fun setOrderList(orderList : List<OrderEntity>){
        this.orderList = orderList
    }
}