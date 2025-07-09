package com.example.mimenu.utils

import android.graphics.Bitmap
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import com.example.mimenu.data.local.Entities.OrderEntity
import com.example.mimenu.data.model.OrderModel
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class AppUtil {
    private constructor()
    companion object{
        private var INSTANCE : AppUtil? = null

        fun getInstance () : AppUtil{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            val instance = AppUtil()
            INSTANCE = instance
            return instance
        }
    }
    fun mapOrder(order: OrderModel) : OrderEntity {
        return  OrderEntity(
            id = order.id, name = order.name, description = order.description, img = order.img, price = order.price, priceTotal = order.priceTotal, quantity = order.quantity, discount = order.discount
        )
    }
    fun formatStringToLocalDate(date : String) : LocalDate {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyy")
        return LocalDate.parse(date,formatter)
    }
    fun formatLocalDateToString(date: LocalDate):String{
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        return date.format(formatter)
    }
    fun createQR(value : String) : Bitmap {
        val encoder = BarcodeEncoder()
        return encoder.encodeBitmap(value, BarcodeFormat.QR_CODE, 700, 700)
    }
    fun formatTextToStrikeThrough(text : String) : SpannableString{
        val spannable = SpannableString(text)
        spannable.setSpan(StrikethroughSpan(),0,text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannable
    }
}