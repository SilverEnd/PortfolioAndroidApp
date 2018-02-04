package com.erikzuo.portfolioandroidapp.ui.main.Contact;

import android.arch.lifecycle.ViewModelProvider;

import com.erikzuo.portfolioandroidapp.data.DataManager;
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider;
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by YifanZuo on 4/2/18.
 */

@Module
public class ContactFragmentModule {
    @Provides
    ContactViewModel contactViewModel(DataManager dataManager,
                                SchedulerProvider schedulerProvider) {
        return new ContactViewModel(dataManager, schedulerProvider);
    }

    @Provides
    ViewModelProvider.Factory provideContactViewModel(ContactViewModel contactViewModel) {
        return new ViewModelProviderFactory<>(contactViewModel);
    }


}
