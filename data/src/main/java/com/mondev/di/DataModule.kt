package com.mondev.di

import com.example.core.repository.SearchProductRemoteDataSource
import com.example.core.repository.SearchRepository
import com.mondev.data.SearchProductRemoteDataSourceImpl
import com.mondev.data.SearchRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideSearchRepository(remoteDataSource: SearchProductRemoteDataSourceImpl):
            SearchRepository=SearchRepositoryImpl(remoteDataSource)

    @Provides
    fun providesRemoteDataSource() = SearchProductRemoteDataSourceImpl()
}