package com.example.di

import com.example.data.repository.local.LocalRepository
import com.example.data.repository.local.LocalRepositoryImpl
import com.example.data.repository.remote.NewsRepository
import com.example.data.repository.remote.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class BindModule {

    @Singleton
    @Binds
    abstract fun bindNewsRepository(repo: NewsRepositoryImpl): NewsRepository


    @Singleton
    @Binds
    abstract fun bindLocalRepository(repo: LocalRepositoryImpl): LocalRepository
}