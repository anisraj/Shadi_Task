package com.example.shaditask.data.repository.data_source

import com.example.shaditask.data.model.ApiResponse
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun saveProfilesData(data: ApiResponse.Result)
    fun getProfilesData(): Flow<List<ApiResponse.Result>>
}