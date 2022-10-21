package com.example.shaditask.data.repository.data_source_impl

import com.example.shaditask.data.api.ApiService
import com.example.shaditask.data.model.ApiResponse
import com.example.shaditask.data.repository.data_source.RemoteDataSource
import retrofit2.Response

class RemoteDataSourceImpl(
    private val apiService: ApiService
) : RemoteDataSource{
    override suspend fun getShadiProfiles(): Response<ApiResponse> {
        return apiService.getShadiProfiles()
    }
}