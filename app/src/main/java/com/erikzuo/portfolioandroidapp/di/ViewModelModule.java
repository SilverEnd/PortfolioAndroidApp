package com.erikzuo.portfolioandroidapp.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.erikzuo.portfolioandroidapp.ui.main.MainViewModel;
import com.erikzuo.portfolioandroidapp.ui.main.contact.ContactViewModel;
import com.erikzuo.portfolioandroidapp.ui.main.home.HomeViewModel;
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    abstract ViewModel bindHomeViewModel(HomeViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ContactViewModel.class)
    abstract ViewModel bindContactViewModel(ContactViewModel viewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory factory);
}
