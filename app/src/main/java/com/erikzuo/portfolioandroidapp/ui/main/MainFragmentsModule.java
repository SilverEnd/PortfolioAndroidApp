package com.erikzuo.portfolioandroidapp.ui.main;

import com.erikzuo.portfolioandroidapp.ui.main.about.AboutFragment;
import com.erikzuo.portfolioandroidapp.ui.main.education.EducationFragment;
import com.erikzuo.portfolioandroidapp.ui.main.education.EducationFragmentModule;
import com.erikzuo.portfolioandroidapp.ui.main.home.HomeFragment;
import com.erikzuo.portfolioandroidapp.ui.main.work.WorkFragment;
import com.erikzuo.portfolioandroidapp.ui.main.work.WorkFragmentModule;
import com.erikzuo.portfolioandroidapp.ui.main.work.WorkFragmentsProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by YifanZuo on 4/2/18.
 */

@Module
public abstract class MainFragmentsModule {

    @ContributesAndroidInjector
    abstract HomeFragment contributeHomeFragment();

    @ContributesAndroidInjector
    abstract AboutFragment contributeContactFragment();

    @ContributesAndroidInjector(modules = {WorkFragmentsProvider.class, WorkFragmentModule.class})
    abstract WorkFragment contributeWorkFragment();


    @ContributesAndroidInjector(modules = EducationFragmentModule.class)
    abstract EducationFragment contributeEducationFragment();
}
