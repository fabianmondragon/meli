package com.mondev.data

import com.example.core.domain.entity.ResultEntity
import com.example.core.repository.SearchProductRemoteDataSource
import com.example.core.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val remoteDataSource: SearchProductRemoteDataSource
) : SearchRepository {
    override suspend fun searchProduct(query: String): List<ResultEntity>? {
        return remoteDataSource.searchProduct(query)
    }
}
