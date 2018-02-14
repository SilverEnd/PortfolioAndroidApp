package com.erikzuo.portfolioandroidapp.ui.main

import com.erikzuo.portfolioandroidapp.ui.main.education.EducationFragment
import com.erikzuo.portfolioandroidapp.ui.main.education.EducationFragmentModule
import com.erikzuo.portfolioandroidapp.ui.main.home.HomeFragment
import com.erikzuo.portfolioandroidapp.ui.main.work.WorkFragment
import com.erikzuo.portfolioandroidapp.ui.main.work.WorkFragmentModule
import com.erikzuo.portfolioandroidapp.ui.main.work.WorkFragmentsProvider

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by YifanZuo on 4/2/18.
 */

@Module
abstract class MainFragmentsModule {

    @ContributesAndroidInjector
    internal abstract fun contributeHomeFragment(): HomeFragment


    @ContributesAndroidInjector(modules = arrayOf(WorkFragmentsProvider::class, WorkFragmentModule::class))
    internal abstract fun contributeWorkFragment(): WorkFragment


    @ContributesAndroidInjector(modules = arrayOf(EducationFragmentModule::class))
    internal abstract fun contributeEducationFragment(): EducationFragment
}
