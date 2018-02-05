package com.erikzuo.portfolioandroidapp.ui.main;


import com.erikzuo.portfolioandroidapp.data.DataManager;
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel;
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by YifanZuo on 4/2/18.
 */

public class MainViewModel extends BaseViewModel<MainNavigator> {

    @Inject
    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
