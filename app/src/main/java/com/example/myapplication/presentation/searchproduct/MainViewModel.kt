package com.example.myapplication.presentation.searchproduct

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.myapplication.UseCases

import com.example.myapplication.di.DaggerMeliComponent
import com.example.myapplication.presentation.model.ResultPresentation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.IllegalArgumentException

class MainViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var useCases: UseCases

    private val TAG = MainViewModel::class.simpleName
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    var productList = MutableLiveData<List<ResultPresentation>>()
    var messague = MutableLiveData<String>()

    @Inject
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
            Log.e(TAG, exception.message)
            messague.value = "Ocurrio un error, por favor intente más tarde"
        } catch (nullExcpetion: NullPointerException) {
            Log.e(TAG, nullExcpetion.message)
            messague.value = "Ocurrio un error, por favor intente más tarde"
        } catch (exception: IllegalArgumentException) {
            Log.e(TAG, exception.message)
            messague.value = "Ocurrio un error, por favor intente más tarde"
        } catch (exception: IllegalStateException) {
            Log.e(TAG, exception.message)
            messague.value = "Ocurrio un error, por favor intente más tarde"

        }


    }

    fun getOnInitialValueDetectedLiveData(): LiveData<List<ResultPresentation>> = productList
    fun getOnShowError(): LiveData<String> = messague

}

