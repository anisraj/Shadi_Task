package com.example.shaditask.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.shaditask.data.db.converters.*
import com.example.shaditask.data.model.ApiResponse

@Database(
    entities = [ApiResponse.Result::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    DobConverter::class, LocationConverter::class,
    NameConverter::class, PictureConverter::class
)
abstract class Database : RoomDatabase() {
    abstract fun getProfileDao(): ProfileDao
}