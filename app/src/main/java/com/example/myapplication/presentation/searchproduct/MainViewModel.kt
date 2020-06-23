package com.example.myapplication.presentation.searchproduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.data.repository.SearchRepository
import com.example.core.domain.entity.ResultEntity
import com.example.core.domain.usecases.SearchProduct
import com.example.myapplication.data.network.SearchProductRemoteDataSourceImpl
import com.example.myapplication.data.network.SearchRepositoryImpl
import com.example.myapplication.presentation.model.ResultPresentation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    lateinit var searchProduct: SearchProduct
    lateinit var searchRepository: SearchRepository
    lateinit var searchRemoteDataSource: SearchProductRemoteDataSourceImpl
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    var productList = MutableLiveData<List<ResultPresentation>>()
    lateinit var mapperDomainToPresentation: MapperDomainToPresentation


    fun searchProduct(query: String?) {
        searchRemoteDataSource = SearchProductRemoteDataSourceImpl()
        searchRepository = SearchRepositoryImpl(searchRemoteDataSource)
        searchProduct = SearchProduct(searchRepository)
        mapperDomainToPresentation = MapperDomainToPresentation()
        coroutineScope.launch {
            productList.postValue(query?.let {
                mapperDomainToPresentation.resultSearchDomainToPresentation(
                    searchProduct.searchRepository(
                        it
                    )
                )
            })
        }
    }

    fun getOnInitialValueDetectedLiveData(): LiveData<List<ResultPresentation>> = productList


}

