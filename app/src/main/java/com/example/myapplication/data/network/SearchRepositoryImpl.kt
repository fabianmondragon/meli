package com.example.myapplication.data.network

import com.example.core.data.repository.SearchProductRemoteDataSource
import com.example.core.data.repository.SearchRepository
import com.example.core.domain.entity.ResultEntity

class SearchRepositoryImpl(private val remoteDataSource: SearchProductRemoteDataSource) :
    SearchRepository {

    override suspend fun searchProduct(query: String): List<ResultEntity>? {
        return remoteDataSource.searchProduct(query)
    }
}