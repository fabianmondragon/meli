package com.example.core.domain.usecases

import com.example.core.data.repository.SearchRepository

class SearchProduct (private val searchRepository: SearchRepository) {
    //suspend operator fun invoke() = searchRepository.searchRepository()
    suspend fun searchRepository (){
        val hola = searchRepository.searchProduct()
        val string = ""
    }
}