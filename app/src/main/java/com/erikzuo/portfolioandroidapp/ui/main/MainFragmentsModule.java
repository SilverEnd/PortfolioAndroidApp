package com.erikzuo.portfolioandroidapp.ui.main;

import android.arch.lifecycle.ViewModelProvider;

import com.erikzuo.portfolioandroidapp.data.DataManager;
import com.erikzuo.portfolioandroidapp.ui.main.contact.ContactFragment;
import com.erikzuo.portfolioandroidapp.ui.main.contact.ContactViewModel;
import com.erikzuo.portfolioandroidapp.ui.main.home.HomeFragment;
import com.erikzuo.portfolioandroidapp.ui.main.home.HomeViewModel;
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider;
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by YifanZuo on 4/2/18.
 */

@Module
public abstract class MainFragmentsModule {

    @ContributesAndroidInjector
    abstract HomeFragment contributeHomeFragment();

    @ContributesAndroidInjector
    abstract ContactFragment contributeContactFragment();


}
