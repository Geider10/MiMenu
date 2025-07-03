package com.example.mimenu.data.Entities

data class VoucherEntity (
    val id : Int,
    val name : String,
    val description : String,
    val img: Int,
    val code : String,
    val expiration : String
        ) : java.io.Serializable