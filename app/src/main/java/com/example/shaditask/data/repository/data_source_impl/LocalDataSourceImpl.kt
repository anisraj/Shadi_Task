package com.example.shaditask.data.repository.data_source_impl

import com.example.shaditask.data.db.ProfileDao
import com.example.shaditask.data.model.ApiResponse
import com.example.shaditask.data.repository.data_source.LocalDataSource
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(
    private val profileDao: ProfileDao
) : LocalDataSource {
    override suspend fun saveProfilesData(data: ApiResponse.Result) {
        profileDao.insert(data)
    }

    override fun getProfilesData(): Flow<List<ApiResponse.Result>> {
        return profileDao.getAllArticles()
    }
}