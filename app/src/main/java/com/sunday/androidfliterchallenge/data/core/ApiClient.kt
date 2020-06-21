package com.sunday.androidfliterchallenge.data.core

import com.sunday.androidfliterchallenge.utils.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal class ApiClient : Service {

    private var retrofit: Retrofit? = null
    private val baseUrl = "https://android-json-test-api.herokuapp.com/"
    private var loggingInterceptor = HttpLoggingInterceptor()

    private fun getRetrofitInstance(): Retrofit? {

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(
                    baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(loggingInterceptor)
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(30, TimeUnit.SECONDS)
                        .build()
                )
                .build()
        }
        return retrofit
    }

    override fun <T> create(classService: Class<T>): T? {

        return getRetrofitInstance()?.create(classService)
    }
}