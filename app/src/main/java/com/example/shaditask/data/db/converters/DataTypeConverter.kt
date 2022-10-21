package com.example.shaditask.data.db.converters

import androidx.room.TypeConverter
import com.example.shaditask.data.model.ApiResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataTypeConverter {

    @TypeConverter
    fun stringToList(data: String): ArrayList<ApiResponse.Result> {
        val listType = object : TypeToken<ArrayList<ApiResponse.Result?>?>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun listToString(data: ArrayList<ApiResponse.Result?>?): String? {
        return Gson().toJson(data)
    }
}