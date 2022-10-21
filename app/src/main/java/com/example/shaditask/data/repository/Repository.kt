package com.example.shaditask.data.repository

import com.example.shaditask.data.model.ApiResponse
import com.example.shaditask.data.repository.data_source.LocalDataSource
import com.example.shaditask.data.repository.data_source.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class Repository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : com.example.shaditask.domain.repository.Repository {
    override suspend fun getShadiProfiles(): Response<ApiResponse> {
        return remoteDataSource.getShadiProfiles()
    }

    override suspend fun saveProfilesData(data: ApiResponse.Result) {
        localDataSource.saveProfilesData(data)
    }

    override fun getProfiles(): Flow<List<ApiResponse.Result>> {
        return localDataSource.getProfilesData()
    }
}