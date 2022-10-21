package com.example.shaditask.data.repository

import com.example.shaditask.data.model.ApiResponse
import com.example.shaditask.data.repository.data_source.RemoteDataSource
import retrofit2.Response

class Repository(
    private val remoteDataSource: RemoteDataSource
) : com.example.shaditask.domain.repository.Repository {
    override suspend fun getShadiProfiles(): Response<ApiResponse> {
        return remoteDataSource.getShadiProfiles()
    }
}