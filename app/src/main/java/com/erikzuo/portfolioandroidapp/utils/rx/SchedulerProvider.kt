package com.erikzuo.portfolioandroidapp.utils.rx

import io.reactivex.Scheduler

/**
 * Created by YifanZuo on 3/2/18.
 */

interface SchedulerProvider {

    fun ui(): Scheduler

    fun computation(): Scheduler

    fun io(): Scheduler

}
