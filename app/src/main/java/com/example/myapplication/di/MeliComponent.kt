package com.example.myapplication.di

import com.example.core.di.DomainModule
import com.example.myapplication.presentation.searchproduct.MainActivity
import com.example.myapplication.presentation.searchproduct.MainViewModel
import com.mondev.di.DataModule
import dagger.Component

@Component(modules = [MeliModule::class,  DataModule::class, DomainModule::class])
interface MeliComponent {
    fun inject(app: MainActivity)
    fun inject(mainViewModel: MainViewModel)
}