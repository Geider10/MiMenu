package com.example.mimenu.view_model

import androidx.lifecycle.ViewModel
import com.example.mimenu.repository.Repository

class CategoryViewModel : ViewModel() {
    private val repo = Repository()
    val getAll = repo.getAllCategory
}