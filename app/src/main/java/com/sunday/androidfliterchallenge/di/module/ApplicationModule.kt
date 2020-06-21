package com.sunday.androidfliterchallenge.di.module

import com.sunday.androidfliterchallenge.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import io.reactivex.disposables.CompositeDisposable

@Module
abstract class ApplicationModule {
    @ContributesAndroidInjector
    abstract fun activityInjector(): MainActivity?

    companion object {
        @Provides
        fun provideCompositeDisposable(): CompositeDisposable {
            return CompositeDisposable()
        }
    }
}