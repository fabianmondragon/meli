package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.presentation.model.ResultPresentation
import com.example.myapplication.presentation.searchproduct.ProductsAdapter
import dagger.Module
import dagger.Provides

@Module
class MeliModule {

    @Provides
    open fun getInstanceProductsAdapter(itemList: List<ResultPresentation>, context: Context) =
        ProductsAdapter(itemList, context)

    @Provides
    fun provideListResultPresentation() = arrayListOf<ResultPresentation>()

}