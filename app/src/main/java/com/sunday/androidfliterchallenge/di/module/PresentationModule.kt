package com.sunday.androidfliterchallenge.di.module

import com.sunday.androidfliterchallenge.presentation.MainActivity
import com.sunday.androidfliterchallenge.presentation.home.car_owners_fragment.CarOwnersFragment
import com.sunday.androidfliterchallenge.presentation.home.filters_fragment.FiltersFragment
import com.sunday.androidfliterchallenge.presentation.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PresentationModule {

    /* Activity builder */
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity?

    /* Fragment Builder */
    @ContributesAndroidInjector
    abstract fun bindFiltersFragment(): FiltersFragment?

    @ContributesAndroidInjector
    abstract fun bindSplashFragment(): SplashFragment?

    @ContributesAndroidInjector
    abstract fun bindCarOwnersFragment(): CarOwnersFragment?

}