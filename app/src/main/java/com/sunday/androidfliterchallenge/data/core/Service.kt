package com.sunday.androidfliterchallenge.data.core

internal interface Service {
    fun <T> create(classService: Class<T>): T?
}