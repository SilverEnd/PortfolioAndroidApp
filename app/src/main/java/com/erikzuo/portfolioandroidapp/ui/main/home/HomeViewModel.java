package com.erikzuo.portfolioandroidapp.ui.main.home;

import com.erikzuo.portfolioandroidapp.data.DataManager;
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel;
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by YifanZuo on 5/2/18.
 */

public class HomeViewModel extends BaseViewModel<HomeNavigator> {


    @Inject
    public HomeViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);

        loadMyInfo();
    }

    private void loadMyInfo() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager().getMyInfo()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(
                        myInfo -> {
                            setMyInfo(myInfo);
                            setIsLoading(false);
                        }, throwable -> {

                        }
                )
        );
    }


 }
