package com.erikzuo.portfolioandroidapp.ui.main.Contact;


import com.erikzuo.portfolioandroidapp.data.DataManager;
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel;
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider;

/**
 * Created by YifanZuo on 4/2/18.
 */

public class ContactViewModel extends BaseViewModel<ContactNavigator> {
    public ContactViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
