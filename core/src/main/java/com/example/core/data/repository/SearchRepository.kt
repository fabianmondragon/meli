package com.example.core.data.repository

import com.example.core.domain.entity.ResultEntity

interface SearchRepository {
    suspend fun searchProduct(): List<ResultEntity>
}