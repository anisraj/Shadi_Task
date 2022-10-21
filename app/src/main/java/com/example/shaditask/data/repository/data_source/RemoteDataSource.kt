package com.example.shaditask.data.repository.data_source

import com.example.shaditask.data.model.ApiResponse
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getShadiProfiles(): Response<ApiResponse>
}