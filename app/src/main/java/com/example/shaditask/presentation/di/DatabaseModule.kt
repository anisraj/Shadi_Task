package com.example.shaditask.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.shaditask.data.db.Database
import com.example.shaditask.data.db.ProfileDao
import com.example.shaditask.data.utils.VariableConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideProfilesDatabase(app: Application): Database {
        return Room.databaseBuilder(app, Database::class.java, VariableConstants.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesDao(database: Database): ProfileDao {
        return database.getProfileDao()
    }
}