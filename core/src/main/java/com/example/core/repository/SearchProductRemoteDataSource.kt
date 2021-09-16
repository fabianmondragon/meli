package com.example.core.repository

import com.example.core.domain.entity.ResultEntity

interface SearchProductRemoteDataSource {

    suspend fun searchProduct(query: String): List<ResultEntity>?
}