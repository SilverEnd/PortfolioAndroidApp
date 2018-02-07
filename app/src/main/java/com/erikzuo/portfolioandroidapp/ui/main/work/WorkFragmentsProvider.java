package com.erikzuo.portfolioandroidapp.ui.main.work;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by YifanZuo on 4/2/18.
 */

@Module
public abstract class WorkFragmentsProvider {

    @ContributesAndroidInjector
    abstract IndustryWorkFragment contributeIndustryWorkFragment();

    @ContributesAndroidInjector
    abstract PersonalWorkFragment contributePersonalWOrkFragment();

}
