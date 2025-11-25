package com.ks.coffeeshop.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ks.coffeeshop.Domain.BannerModel
import com.ks.coffeeshop.Domain.CategoryModel
import com.ks.coffeeshop.Repository.MainRepository

class MainViewModel: ViewModel() {
    private val repository = MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()
    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>>{
        return repository.loadCategory()
    }
}