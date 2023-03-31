package com.example.mvvmarchitectureabbtech.di

import android.content.Context
import androidx.room.Room
import com.example.mvvmarchitectureabbtech.data.model.User
import com.example.mvvmarchitectureabbtech.local.ConnectRoomDatabase
import com.example.mvvmarchitectureabbtech.local.ConnectRoomDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): ConnectRoomDatabase {
        return Room
            .databaseBuilder(appContext, ConnectRoomDatabase::class.java, DATABASE_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(db: ConnectRoomDatabase) = db.userDao()


}