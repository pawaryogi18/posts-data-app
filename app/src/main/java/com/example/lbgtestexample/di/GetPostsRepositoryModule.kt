package com.example.lbgtestexample.di

import com.example.lbgtestexample.data.repository.GetPostsDataRepositoryImpl
import com.example.lbgtestexample.domain.repository.GetPostsDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class GetPostsRepositoryModule {
    @Binds
    abstract fun provideBinds(impl: GetPostsDataRepositoryImpl): GetPostsDataRepository
}