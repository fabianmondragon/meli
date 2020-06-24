package com.example.core.domain.usecases

import com.example.core.data.repository.SearchRepository
import com.example.core.domain.entity.ResultEntity

class SearchProduct(private val searchRepository: SearchRepository) {
    suspend fun searchRepository(query: String): List<ResultEntity>? {
        return searchRepository.searchProduct(query)
    }
}