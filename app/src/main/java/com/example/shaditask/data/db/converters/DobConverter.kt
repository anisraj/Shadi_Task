package com.example.shaditask.data.db.converters

import androidx.room.TypeConverter
import com.example.shaditask.data.model.ApiResponse

class DobConverter {
    @TypeConverter
    fun fromSource(source: ApiResponse.Result.Dob): String? {
        return "${source.age}"
    }

    @TypeConverter
    fun toSource(name: String): ApiResponse.Result.Dob {
        return ApiResponse.Result.Dob(name)
    }
}