package com.example.myapplication.presentation.searchproduct

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.data.repository.SearchRepository
import com.example.core.domain.entity.ResultEntity
import com.example.core.domain.usecases.SearchProduct
import com.example.myapplication.UseCases
import com.example.myapplication.data.network.SearchProductRemoteDataSourceImpl
import com.example.myapplication.data.network.SearchRepositoryImpl
import com.example.myapplication.di.DaggerMeliComponent
import com.example.myapplication.presentation.model.ResultPresentation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var useCases: UseCases


    lateinit var searchRepository: SearchRepository
    lateinit var searchRemoteDataSource: SearchProductRemoteDataSourceImpl
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    var productList = MutableLiveData<List<ResultPresentation>>()
    var messague = MutableLiveData<String>()
    lateinit var mapperDomainToPresentation: MapperDomainToPresentation

    init {
        DaggerMeliComponent.builder()
            .build()
            .inject(this)
    }

    fun searchProduct(query: String?) {

        try {
            mapperDomainToPresentation = MapperDomainToPresentation()
            coroutineScope.launch {
                useCases.searchProduct.searchRepository(query!!)?.let {
                    if (it.size == 0) {
                        messague.postValue("No se encontró resultados")
                    } else {
                        productList.postValue(
                            mapperDomainToPresentation.resultSearchDomainToPresentation(
                                it
                            )
                        )
                    }
                }
            }
        } catch (exception: Exception) {
            messague.value = "Ocurrio un error, por favor intente más tarde"
        }

    }

    fun getOnInitialValueDetectedLiveData(): LiveData<List<ResultPresentation>> = productList
    fun getOnShowError(): LiveData<String> = messague

}

