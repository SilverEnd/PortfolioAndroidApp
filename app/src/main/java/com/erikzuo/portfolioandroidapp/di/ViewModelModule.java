package com.erikzuo.portfolioandroidapp.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.erikzuo.portfolioandroidapp.ui.main.MainViewModel;
import com.erikzuo.portfolioandroidapp.ui.main.about.AboutViewModel;
import com.erikzuo.portfolioandroidapp.ui.main.home.HomeViewModel;
import com.erikzuo.portfolioandroidapp.ui.main.work.WorkViewModel;
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
    @ViewModelKey(AboutViewModel.class)
    abstract ViewModel bindContactViewModel(AboutViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(WorkViewModel.class)
    abstract ViewModel bindWorkViewModel(WorkViewModel viewModel);




    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory factory);
}
