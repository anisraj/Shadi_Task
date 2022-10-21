package com.example.shaditask.domain.repository

import com.example.shaditask.data.model.ApiResponse
import retrofit2.Response

interface Repository {
    suspend fun getShadiProfiles(): Response<ApiResponse>
}