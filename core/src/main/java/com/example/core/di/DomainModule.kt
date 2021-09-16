package com.example.core.di

import com.example.core.repository.SearchRepository
import com.example.core.domain.usecases.SearchProductUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideSearchUseCase (searchRepository: SearchRepository)= SearchProductUseCase(searchRepository)



}