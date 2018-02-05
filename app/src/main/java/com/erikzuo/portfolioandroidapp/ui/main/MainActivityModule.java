package com.erikzuo.portfolioandroidapp.ui.main;


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
public class MainActivityModule {
    @Provides
    MainViewModel provideMainViewModel(DataManager dataManager,
                                       SchedulerProvider schedulerProvider) {
        return new MainViewModel(dataManager, schedulerProvider);
    }

    @Provides
    ViewModelProvider.Factory provideBlogViewModel(MainViewModel viewModel) {
        return new ViewModelProviderFactory<>(viewModel);
    }

    @Provides
    MainPagerAdapter provideFeedPagerAdapter(MainActivity activity) {
        return new MainPagerAdapter(activity.getSupportFragmentManager());
    }

}
