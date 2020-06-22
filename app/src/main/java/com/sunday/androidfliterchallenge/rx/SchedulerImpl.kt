
package com.sunday.androidfliterchallenge.rx
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SchedulerImpl @Inject constructor() : com.sunday.androidfliterchallenge.rx.Scheduler {

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun background(): Scheduler {
        return Schedulers.io()
    }
}