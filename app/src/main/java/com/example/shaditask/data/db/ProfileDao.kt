package com.example.shaditask.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shaditask.data.model.ApiResponse
import com.example.shaditask.data.utils.VariableConstants
import com.example.shaditask.data.utils.VariableConstants.Companion.TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(result: ApiResponse.Result)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllArticles(): Flow<List<ApiResponse.Result>>
}