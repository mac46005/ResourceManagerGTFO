package com.example.resourcemanagergtfo.di

import com.example.resourcemanagergtfo.core.models.app_models.GTFOResourceManager
import com.example.resourcemanagergtfo.data.ResourceRepo
import com.example.resourcemanagergtfo.data.ZoneRepo
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
    fun providesResourceManager(): GTFOResourceManager{
        return GTFOResourceManager()
    }

    @Provides
    @Singleton
    fun providesZoneRepo(): ZoneRepo{
        return ZoneRepo()
    }

    @Provides
    @Singleton
    fun providesResourceRepo(): ResourceRepo{
        return ResourceRepo()
    }
}