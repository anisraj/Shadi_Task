package com.example.shaditask.domain.usecase

import com.example.shaditask.data.model.ApiResponse
import com.example.shaditask.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class GetLocalProfilesUseCase @Inject constructor(private val repository: Repository) {
    fun execute(): Flow<List<ApiResponse.Result>> {
        return repository.getProfiles()
    }
}