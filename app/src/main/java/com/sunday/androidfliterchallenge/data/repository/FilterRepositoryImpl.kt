package com.sunday.androidfliterchallenge.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sunday.androidfliterchallenge.data.entity.Filter
import com.sunday.androidfliterchallenge.data.remote.FilterService
import com.sunday.androidfliterchallenge.utils.Resource
import javax.inject.Inject

public class FilterRepositoryImpl @Inject constructor(
    val filterService: FilterService) : FilterRepository {

    private var filters  = MutableLiveData<Resource<List<Filter>>>()

    override fun getFilters() {
        TODO("Not yet implemented")
    }

    override fun filtersObserver(): LiveData<Resource<List<Filter>>> = filters


}