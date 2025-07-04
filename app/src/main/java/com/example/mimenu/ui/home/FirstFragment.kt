package com.example.mimenu.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mimenu.R
import com.example.mimenu.data.Entities.BannerEntity
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.data.Entities.VoucherEntity
import com.example.mimenu.data.model.VoucherModel
import com.example.mimenu.databinding.FragmentFirstBinding
import com.example.mimenu.view_model.AppViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class FirstFragment : Fragment(), OnClickHome {

    private lateinit var binding : FragmentFirstBinding
    private val appViewModel by viewModels<AppViewModel>()

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
        val adapter = BannerAdapter(appViewModel.getAllBanners)
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
    }

    private fun setupDiscountRecycler(){
        val adapter = DiscountAdapter(appViewModel.getAllFoodOffer, this)
        binding.rvDiscountHome.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvDiscountHome.adapter = adapter
    }
    override fun onClickDiscount(food: FoodEntity) {
        val order = OrderEntity(name= food.name, description = food.description, price = food.price, img = food.img, priceTotal = food.price, quantity = 1, discount = food.discount)
        val action = FirstFragmentDirections.actionFirstFragmentToFoodDetailFragment(order,3)
        findNavController().navigate(action)
    }

    override fun onClickVoucher(voucher: VoucherModel) {
        val action = FirstFragmentDirections.actionFirstFragmentToVocuherDetailFragment(voucher)
        findNavController().navigate(action)
    }

    private fun setupVoucherRecycler(){
        val adapter = VoucherAdapter(appViewModel.getAllVouchers, this)
        binding.rvVoucherHome.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvVoucherHome.adapter =adapter
    }

}
