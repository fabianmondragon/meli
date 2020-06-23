package com.example.myapplication.di

import com.example.core.domain.usecases.SearchProduct
import com.example.myapplication.UseCases
import com.example.myapplication.data.network.SearchProductRemoteDataSourceImpl
import com.example.myapplication.data.network.SearchRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideDataSource() = SearchProductRemoteDataSourceImpl()

    @Provides
    fun provideRepository(remoteDataSource: SearchProductRemoteDataSourceImpl) =
        SearchRepositoryImpl(remoteDataSource)

    @Provides
    fun provideSearchProduct(searchRepository: SearchRepositoryImpl) = UseCases(
        SearchProduct(searchRepository)
    )


}