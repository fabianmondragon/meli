package com.example.core.domain.usecases

import com.example.core.domain.entity.ResultEntity
import com.example.core.repository.SearchRepository
import javax.inject.Inject

class SearchProductUseCase @Inject constructor(private val searchRepository: SearchRepository) {
    suspend fun searchRepository(query: String): List<ResultEntity>? {
        return searchRepository.searchProduct(query)
    }
}