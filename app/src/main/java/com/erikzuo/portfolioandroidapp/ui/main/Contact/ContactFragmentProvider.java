package com.erikzuo.portfolioandroidapp.ui.main.Contact;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by YifanZuo on 4/2/18.
 */

@Module
public abstract class ContactFragmentProvider {

    @ContributesAndroidInjector(modules = ContactFragmentModule.class)
    abstract ContactFragment provideContactFragmentFactory();

}
