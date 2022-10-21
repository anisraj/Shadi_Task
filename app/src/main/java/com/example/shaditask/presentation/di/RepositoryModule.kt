package com.example.shaditask.presentation.di

import com.example.shaditask.data.repository.data_source.LocalDataSource
import com.example.shaditask.data.repository.data_source.RemoteDataSource
import com.example.shaditask.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun providesRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): Repository {
        return com.example.shaditask.data.repository.Repository(remoteDataSource, localDataSource)
    }
}