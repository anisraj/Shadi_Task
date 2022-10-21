package com.example.shaditask.data.db.converters

import androidx.room.TypeConverter
import com.example.shaditask.data.model.ApiResponse

class NameConverter {
    @TypeConverter
    fun fromSource(source: ApiResponse.Result.Name): String? {
        return "${source.title}. ${source.first} ${source.last}"
    }

    @TypeConverter
    fun toSource(name: String): ApiResponse.Result.Name {
        return ApiResponse.Result.Name(name, "", "")
    }
}