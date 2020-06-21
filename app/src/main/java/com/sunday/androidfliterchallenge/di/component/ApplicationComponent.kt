package com.sunday.androidfliterchallenge.di.component

import com.sunday.androidfliterchallenge.di.module.ApplicationModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


@Component(modules = [AndroidInjectionModule::class, ApplicationModule::class])
interface ApplicationComponent : AndroidInjector<App?>