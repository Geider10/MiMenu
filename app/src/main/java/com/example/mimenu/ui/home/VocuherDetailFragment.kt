package com.example.mimenu.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mimenu.MainActivity
import com.example.mimenu.R
import com.example.mimenu.data.model.VoucherModel
import com.example.mimenu.databinding.FragmentVocuherDetailBinding
import com.example.mimenu.utils.AppUtil

class VocuherDetailFragment : Fragment() {

    private lateinit var binding : FragmentVocuherDetailBinding
    private lateinit var voucher : VoucherModel
    private val appUtil = AppUtil.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVocuherDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args : VocuherDetailFragmentArgs by navArgs()
        voucher = args.voucher

        setDataVoucher()
        binding.btnVoucherDetail.setOnClickListener{
            binding.llContentCode.visibility = View.VISIBLE

            val bitmapQR = appUtil.createQR(voucher.code)
            binding.ivQRVoucherDetail.setImageBitmap(bitmapQR)
        }

        var main = requireActivity() as MainActivity
        main.disableBottomNav()
    }

    override fun onDestroy() {
        super.onDestroy()
        var main = requireActivity() as MainActivity
        main.enableBottomNav()
    }
    private fun setDataVoucher() {
        binding.llContentCode.visibility = View.GONE

        val dueDate = appUtil.formatLocalDateToString(voucher.expiration)
        binding.ivVoucherDetail.setBackgroundResource(voucher.img)
        binding.tvNameVoucherDetail.text = voucher.name
        binding.tvDescriptionVoucherDetail.text = voucher.description
        binding.tvCodeVoucherDetail.text = voucher.code
        binding.tvExpirationVoucherDetail.text = "Vence el $dueDate"

    }

}