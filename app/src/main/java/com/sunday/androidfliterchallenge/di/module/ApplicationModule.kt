package com.sunday.androidfliterchallenge.di.module

import com.sunday.androidfliterchallenge.data.remote.FilterService
import com.sunday.androidfliterchallenge.data.repository.FilterRepository
import com.sunday.androidfliterchallenge.data.repository.FilterRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
public class ApplicationModule {

    @Provides
    fun filterRepositoryProvider(filterService: FilterService) : FilterRepository {
        return FilterRepositoryImpl(filterService)
    }
}