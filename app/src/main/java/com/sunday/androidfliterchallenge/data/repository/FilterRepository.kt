package com.sunday.androidfliterchallenge.data.repository

import androidx.lifecycle.LiveData
import com.sunday.androidfliterchallenge.data.entity.Filter
import com.sunday.androidfliterchallenge.utils.Resource

interface FilterRepository {

    fun getFilters()
    fun filtersObserver() : LiveData<Resource<List<Filter>>>
}