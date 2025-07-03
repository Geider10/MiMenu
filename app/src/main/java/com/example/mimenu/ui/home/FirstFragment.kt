package com.example.mimenu.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.mimenu.R
import com.example.mimenu.data.AppDataBase
import com.example.mimenu.data.Entities.BannerEntity
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.data.Entities.VoucherEntity
import com.example.mimenu.databinding.FragmentFirstBinding
import com.example.mimenu.view_model.FoodViewModel
import me.relex.circleindicator.CircleIndicator3

class FirstFragment : Fragment(), OnClickHome {

    private lateinit var binding : FragmentFirstBinding
    private val foodViewModel by viewModels<FoodViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
        setupDiscountRecycler()
        setupVoucherRecycler()
    }
    private fun setupViewPager(){
        val adapter = BannerAdapter(getBanner())
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
    }
    private fun getBanner() : List<BannerEntity>{
        val bannerList = listOf(
            BannerEntity(1,R.mipmap.b1,"Banner 1" ),
            BannerEntity(2,R.mipmap.b2,"Banner 2" ),
            BannerEntity(3,R.mipmap.b33,"Banner 3" ),
            BannerEntity(4,R.mipmap.b44,"Banner 4" )
        )
        return bannerList
    }
    private fun setupDiscountRecycler(){
        val adapter = DiscountAdapter(foodViewModel.getOffer, this)
        binding.rvDiscountHome.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvDiscountHome.adapter = adapter
    }
    override fun onClickDiscount(food: FoodEntity) {
        val order = OrderEntity(name= food.name, description = food.description, price = food.price, img = food.img, priceTotal = food.price, quantity = 1, discount = food.discount)
        val action = FirstFragmentDirections.actionFirstFragmentToFoodDetailFragment(order,3)
        findNavController().navigate(action)
    }

    override fun onClickVoucher(voucher: VoucherEntity) {
        TODO("Not yet implemented")
    }

    private fun setupVoucherRecycler(){
        val adapter = VoucherAdapter(getAllVoucher(), this)
        binding.rvVoucherHome.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvVoucherHome.adapter =adapter
    }
    private fun getAllVoucher() : List<VoucherEntity>{
        return listOf(
            VoucherEntity(id = 0, name = "Combo Cuarto Deluxe + Combo Pollo Crispy", description = "", img = R.mipmap.c2a, code = "54-2353-1646", expiration = "03/07/2025"),
            VoucherEntity(id = 1, name = "Combo Cuarto Deluxe + Combo Pollo Crispy", description = "", img = R.mipmap.c2a, code = "59-2353-1646", expiration = "10/08/2025"),
            VoucherEntity(id = 2, name = "Combo Cuarto Deluxe + Combo Pollo Crispy", description = "", img = R.mipmap.c2a, code = "42-2353-1646", expiration = "20/09/2025")
        )
    }
}
