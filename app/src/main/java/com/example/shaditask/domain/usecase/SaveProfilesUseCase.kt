package com.example.shaditask.domain.usecase

import com.example.shaditask.data.model.ApiResponse
import com.example.shaditask.domain.repository.Repository
import retrofit2.Response
import javax.inject.Inject

class SaveProfilesUseCase @Inject constructor(private val repository: Repository) {
    suspend fun execute(data: ApiResponse.Result) {
        repository.saveProfilesData(data)
    }
}