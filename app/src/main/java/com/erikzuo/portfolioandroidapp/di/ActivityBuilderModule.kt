package com.erikzuo.portfolioandroidapp.di


import com.erikzuo.portfolioandroidapp.ui.contact.ContactActivity
import com.erikzuo.portfolioandroidapp.ui.main.MainActivity
import com.erikzuo.portfolioandroidapp.ui.main.MainFragmentsModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by YifanZuo on 3/2/18.
 */

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(MainFragmentsModule::class))
    internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeContactActivity(): ContactActivity
}
