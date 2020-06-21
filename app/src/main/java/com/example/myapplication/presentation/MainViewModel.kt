package com.example.myapplication.presentation

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.data.repository.SearchRepository
import com.example.core.domain.entity.ResultEntity
import com.example.core.domain.usecases.SearchProduct
import com.example.myapplication.data.network.SearchProductRemoteDataSourceImpl
import com.example.myapplication.data.network.SearchRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    lateinit var searchProduct: SearchProduct
    lateinit var searchRepository: SearchRepository
    lateinit var searchRemoteDataSource: SearchProductRemoteDataSourceImpl
    lateinit var textView: TextView
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    var listProdut = MutableLiveData<List<ResultEntity>>()

    fun searchProduct() {
        searchRemoteDataSource = SearchProductRemoteDataSourceImpl()
        searchRepository = SearchRepositoryImpl(searchRemoteDataSource)
        searchProduct = SearchProduct(searchRepository)
        coroutineScope.launch {
            listProdut.postValue(searchProduct.searchRepository())
        }
    }


    fun getOnInitialValueDetectedLiveData(): LiveData<List<ResultEntity>> = listProdut


}

