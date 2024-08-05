package com.example.data.datasourceImpl

import android.app.Application
import android.content.Context
import com.example.data.datasource.CityDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.Locale

@Module
@InstallIn(SingletonComponent::class)
object  di {
    @Provides
    fun provideCityDataSource(context: Context): CityDataSource {
        return CityDataSourceImpl(context)
    }

    @Provides
    fun provideContext(application: Application): Context = application.applicationContext
}