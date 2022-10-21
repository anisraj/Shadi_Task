package com.example.shaditask.data.db.converters

import androidx.room.TypeConverter
import com.example.shaditask.data.model.ApiResponse

class PictureConverter {
    @TypeConverter
    fun fromSource(source: ApiResponse.Result.Picture): String? {
        return source.large
    }

    @TypeConverter
    fun toSource(name: String): ApiResponse.Result.Picture {
        return ApiResponse.Result.Picture(name)
    }
}