package com.example.core.data.repository

import com.example.core.domain.entity.ResultEntity
import java.sql.ResultSet

interface  SearchProductRemoteDataSource {

    suspend fun searchProduct (): List<ResultEntity>
}