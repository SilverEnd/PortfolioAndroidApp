package com.erikzuo.portfolioandroidapp.ui.main.work

import com.erikzuo.portfolioandroidapp.ui.main.work.industry.IndustryWorkFragment
import com.erikzuo.portfolioandroidapp.ui.main.work.personal.PersonalWorkFragment
import com.erikzuo.portfolioandroidapp.ui.main.work.personal.PersonalWorkFragmentModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by YifanZuo on 4/2/18.
 */

@Module
abstract class WorkFragmentsProvider {

    @ContributesAndroidInjector
    internal abstract fun contributeIndustryWorkFragment(): IndustryWorkFragment

    @ContributesAndroidInjector(modules = arrayOf(PersonalWorkFragmentModule::class))
    internal abstract fun contributePersonalWorkFragment(): PersonalWorkFragment

}
