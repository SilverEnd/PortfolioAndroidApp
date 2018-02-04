package com.erikzuo.portfolioandroidapp.di;


import com.erikzuo.portfolioandroidapp.ui.main.Contact.ContactFragmentProvider;
import com.erikzuo.portfolioandroidapp.ui.main.MainActivity;
import com.erikzuo.portfolioandroidapp.ui.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by YifanZuo on 3/2/18.
 */

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = {MainActivityModule.class, ContactFragmentProvider.class})
    abstract MainActivity bindMainActivity();
}
