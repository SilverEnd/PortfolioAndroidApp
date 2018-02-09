package com.erikzuo.portfolioandroidapp.ui.main.about;


import com.erikzuo.portfolioandroidapp.data.DataManager;
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel;
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by YifanZuo on 4/2/18.
 */

public class AboutViewModel extends BaseViewModel<AboutNavigator> {

    @Inject
    public AboutViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);

    }

}
