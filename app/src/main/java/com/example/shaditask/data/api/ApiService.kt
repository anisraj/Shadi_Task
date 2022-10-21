package com.example.shaditask.data.api

import com.example.shaditask.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/")
    suspend fun getShadiProfiles(
        @Query("results") results: Int = 10
    ): Response<ApiResponse>
}