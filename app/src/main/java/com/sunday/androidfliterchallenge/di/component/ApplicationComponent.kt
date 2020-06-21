package com.sunday.androidfliterchallenge.di.component

import com.sunday.androidfliterchallenge.di.module.ApplicationModule
import com.sunday.androidfliterchallenge.presentation.core.BaseActivity
import dagger.Component

@Component(modules = [ ApplicationModule::class ])
interface ApplicationComponent {
    fun inject(app: BaseActivity)
}