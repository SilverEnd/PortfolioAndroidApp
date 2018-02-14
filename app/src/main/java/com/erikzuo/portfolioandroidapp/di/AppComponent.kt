package com.erikzuo.portfolioandroidapp.di

import android.app.Application


import com.erikzuo.portfolioandroidapp.App

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

/**
 * Created by YifanZuo on 3/2/18.
 */

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    fun inject(app: App)

}
