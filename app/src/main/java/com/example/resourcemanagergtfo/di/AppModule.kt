package com.example.resourcemanagergtfo.di

import com.example.resourcemanagergtfo.core.models.app_models.ResourceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesResourceManager(): ResourceManager{
        return ResourceManager()
    }
}