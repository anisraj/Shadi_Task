package com.example.shaditask.presentation.di

import com.example.shaditask.data.api.ApiService
import com.example.shaditask.data.repository.data_source.RemoteDataSource
import com.example.shaditask.data.repository.data_source_impl.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun providesRemoteDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }
}