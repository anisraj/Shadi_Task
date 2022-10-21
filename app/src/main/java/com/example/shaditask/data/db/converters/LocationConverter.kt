package com.example.shaditask.data.db.converters

import androidx.room.TypeConverter
import com.example.shaditask.data.model.ApiResponse

class LocationConverter {
    @TypeConverter
    fun fromSource(source: ApiResponse.Result.Location): String? {
        return "${source.city} ${source.state}"
    }

    @TypeConverter
    fun toSource(name: String): ApiResponse.Result.Location {
        return ApiResponse.Result.Location(name, "")
    }
}