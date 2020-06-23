package com.example.myapplication.di

import com.example.myapplication.presentation.detail.DetailActivity
import com.example.myapplication.presentation.searchproduct.MainActivity
import com.example.myapplication.presentation.searchproduct.MainViewModel
import com.example.myapplication.presentation.searchproduct.ProductsAdapter
import dagger.Component

@Component(modules = [MeliModule::class, DomainModule::class])
interface MeliComponent {
    fun inject(app: MainActivity)
    fun inject(mainViewModel: MainViewModel)
}