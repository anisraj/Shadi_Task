package com.example.shaditask.domain.repository

import com.example.shaditask.data.model.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface Repository {
    suspend fun getShadiProfiles(): Response<ApiResponse>
    suspend fun saveProfilesData(data: ApiResponse.Result)
    fun getProfiles(): Flow<List<ApiResponse.Result>>
}