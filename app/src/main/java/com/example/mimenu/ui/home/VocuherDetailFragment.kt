package com.example.mimenu.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mimenu.data.model.VoucherModel
import com.example.mimenu.databinding.FragmentVocuherDetailBinding
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class VocuherDetailFragment : Fragment() {

    private lateinit var binding : FragmentVocuherDetailBinding
    private lateinit var voucher : VoucherModel
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
            createQR()
        }
    }

    private fun setDataVoucher() {
        binding.llContentCode.visibility = View.GONE

        binding.ivVoucherDetail.setBackgroundResource(voucher.img)
        binding.tvNameVoucherDetail.text = voucher.name
        binding.tvDescriptionVoucherDetail.text = voucher.description
        binding.tvCodeVoucherDetail.text = voucher.code
        binding.tvExpirationVoucherDetail.text = "Vence el "+ localDateToString(voucher.expiration)

    }
    private fun createQR() {
        binding.llContentCode.visibility = View.VISIBLE
        try {
            val code = voucher.code
            val encoder = BarcodeEncoder()
            val bitmap = encoder.encodeBitmap(code, BarcodeFormat.QR_CODE, 700, 700)
            binding.ivQRVoucherDetail.setImageBitmap(bitmap)
        }
        catch (e : Exception){
            Log.e("VoucherDetail", "craete code QR  $e")
        }
    }

    private fun localDateToString(date: LocalDate):String{
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        return date.format(formatter)
    }
}