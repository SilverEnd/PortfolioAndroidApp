package com.erikzuo.portfolioandroidapp.ui.main.work;

import com.erikzuo.portfolioandroidapp.data.DataManager;
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel;
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by Soprano on 7/02/2018.
 */

public class WorkViewModel extends BaseViewModel<WorkNavigator> {

    @Inject
    public WorkViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
