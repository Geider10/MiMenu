package com.example.mimenu.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mimenu.data.model.FoodModel
import com.example.mimenu.data.model.OrderModel
import com.example.mimenu.data.model.VoucherModel
import com.example.mimenu.databinding.FragmentFirstBinding
import com.example.mimenu.view_model.AppViewModel

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

        setupBannerViewPager()
        setupMainRecycler()
    }
    private fun setupBannerViewPager(){
        val adapter = BannerAdapter(appViewModel.getAllBanners)
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
    }
    override fun onClickDiscount(food: FoodModel) {
        val order = OrderModel(name= food.name, description = food.description, price = food.price, img = food.img, priceTotal = food.price, quantity = 1, discount = food.discount)
        val action = FirstFragmentDirections.actionFirstFragmentToFoodDetailFragment(order,3)
        findNavController().navigate(action)
    }

    override fun onClickVoucher(voucher: VoucherModel) {
        val action = FirstFragmentDirections.actionFirstFragmentToVocuherDetailFragment(voucher)
        findNavController().navigate(action)
    }
    private fun setupMainRecycler(){
        val foodOfferList = appViewModel.getAllFoodOffer(4)
        val voucherList = appViewModel.getAllVouchers(4)
        val dataSectionList = listOf(
            DataSectionHome(1, voucherList = voucherList),
            DataSectionHome(2, foodOfferList = foodOfferList)
        )
        val mainAdapter = MainAdapter(dataSectionList,this)
        binding.rvMain.setHasFixedSize(true)
        binding.rvMain.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMain.adapter = mainAdapter
    }
}
