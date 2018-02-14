package com.erikzuo.portfolioandroidapp

import android.app.Activity
import android.app.Application
import com.erikzuo.portfolioandroidapp.di.DaggerAppComponent


import javax.inject.Inject

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector

/**
 * Created by YifanZuo on 3/2/18.
 */

class App : Application(), HasActivityInjector {

    @Inject
    internal lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }
}
