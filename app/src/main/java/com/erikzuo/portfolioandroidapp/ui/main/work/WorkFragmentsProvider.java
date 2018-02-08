package com.erikzuo.portfolioandroidapp.ui.main.work;

import com.erikzuo.portfolioandroidapp.ui.main.work.industry.IndustryWorkFragment;
import com.erikzuo.portfolioandroidapp.ui.main.work.personal.PersonalWorkFragment;
import com.erikzuo.portfolioandroidapp.ui.main.work.personal.PersonalWorkFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by YifanZuo on 4/2/18.
 */

@Module
public abstract class WorkFragmentsProvider {

    @ContributesAndroidInjector
    abstract IndustryWorkFragment contributeIndustryWorkFragment();

    @ContributesAndroidInjector(modules = PersonalWorkFragmentModule.class)
    abstract PersonalWorkFragment contributePersonalWorkFragment();

}
