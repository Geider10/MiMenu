package com.example.mimenu.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.mimenu.R
import com.example.mimenu.data.AppDataBase
import com.example.mimenu.data.Entities.BannerEntity
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.databinding.FragmentFirstBinding
import me.relex.circleindicator.CircleIndicator3

class FirstFragment : Fragment() {

    private lateinit var binding : FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadViewPager()
    }
    private fun loadViewPager(){
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

}
