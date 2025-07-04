package com.example.mimenu.data.Entities

import java.time.LocalDate

data class VoucherEntity (
    val id : Int,
    val name : String,
    val description : String,
    val img: Int,
    val code : String,
    val expiration : LocalDate,
    val category : String
        ) : java.io.Serializable