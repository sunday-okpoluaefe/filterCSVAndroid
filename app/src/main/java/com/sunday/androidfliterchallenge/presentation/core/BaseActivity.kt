package com.sunday.androidfliterchallenge.presentation.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sunday.androidfliterchallenge.di.component.DaggerApplicationComponent

open class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerApplicationComponent.create().inject(this)
        super.onCreate(savedInstanceState)
    }
}


// AndroidInjection.inject(this);